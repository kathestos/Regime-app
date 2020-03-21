package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.models.Classification;
import com.example.myapplication.models.Classifier;
import com.example.myapplication.models.TensorFlowClassifier;
import com.example.myapplication.views.DrawModel;
import com.example.myapplication.views.DrawView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AiActivity extends Activity implements View.OnClickListener, View.OnTouchListener {
    private static final int PIXEL_WIDTH = 28;
    private Button clearBtn, classBtn;
    private TextView resText, numberTxt, aiTxt;
    private List<Classifier> mClassifiers = new ArrayList<>();
    private DrawModel drawModel;
    private DrawView drawView;
    private PointF mTmpPiont = new PointF();
    private float mLastX;
    private float mLastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ai);

        drawView = findViewById(R.id.draw);
        drawModel = new DrawModel(PIXEL_WIDTH, PIXEL_WIDTH);
        drawView.setModel(drawModel);
        drawView.setOnTouchListener(this);

        clearBtn = findViewById(R.id.btn_clear);
        clearBtn.setOnClickListener(this);

        classBtn = findViewById(R.id.btn_class);
        classBtn.setOnClickListener(this);

        resText = findViewById(R.id.tfRes);
        numberTxt = findViewById(R.id.number);
        aiTxt = findViewById(R.id.ai_text);

        loadModel();
    }

    @Override
    protected void onResume() {
        drawView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        drawView.onPause();
        super.onPause();
    }

    private void loadModel() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mClassifiers.add(
                            TensorFlowClassifier.create(getAssets(), "TensorFlow",
                                    "opt_mnist_convnet-tf.pb", "labels.txt", PIXEL_WIDTH,
                                    "input", "output", true));
                    mClassifiers.add(
                            TensorFlowClassifier.create(getAssets(), "Keras",
                                    "opt_mnist_convnet-keras.pb", "labels.txt", PIXEL_WIDTH,
                                    "conv2d_1_input", "dense_2/Softmax", false));
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing classifiers!", e);
                }
            }
        }).start();
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            drawModel.clear();
            drawView.reset();
            drawView.invalidate();
            resText.setText("");
        } else if (view.getId() == R.id.btn_class) {
            float[] pixels = drawView.getPixelData();
            StringBuilder text = new StringBuilder();
            float[][] map = new float[][]{{0, 0}, {0, 0}};
            int i = 0;
            String mojTxt;
            for (Classifier classifier : mClassifiers) {
                final Classification res = classifier.recognize(pixels);
                if (res.getLabel() == null) {
                    text.append(classifier.name()).append(": ?\n");
                } else {
                    map[i][0] = Float.parseFloat(res.getLabel());
                    map[i++][1] = res.getConf();
                    text.append(String.format("%s: %s, %f\n", classifier.name(), res.getLabel(),
                            res.getConf()));
                }
            }
            if (map[0][0] == map[1][0]) {
                numberTxt.setText(Integer.toString((int) map[0][0]));
                if (map[0][1] > map[1][1]) {
                    mojTxt = String.format("Izgleda da je to broj %s.\n%s%% sam siguran u to.", (int) map[0][0], round(map[0][1] * 100, 2));
                    aiTxt.setText(mojTxt);
                } else {
                    mojTxt = String.format("Izgleda da je to broj %s.\n%s%% sam siguran u to.", (int) map[1][0], round(map[1][1] * 100, 2));
                    aiTxt.setText(mojTxt);
                }
            } else {
                if (map[0][1] > map[1][1]) {
                    numberTxt.setText(Integer.toString((int) map[0][0]));
                    mojTxt = String.format("Izgleda da je to broj %s.\n%s%% sam siguran u to.", (int) map[0][0], round(map[0][1] * 100, 2));
                    aiTxt.setText(mojTxt);
                } else {
                    numberTxt.setText(Integer.toString((int) map[1][0]));
                    mojTxt = String.format("Izgleda da je to broj %s.\n%s%% sam siguran u to.", (int) map[1][0], round(map[1][1] * 100, 2));
                    aiTxt.setText(mojTxt);
                }
            }
            resText.setText(text.toString());
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        if (action == MotionEvent.ACTION_DOWN) {
            processTouchDown(event);
            return true;
        } else if (action == MotionEvent.ACTION_MOVE) {
            processTouchMove(event);
            return true;
        } else if (action == MotionEvent.ACTION_UP) {
            processTouchUp();
            return true;
        }
        return false;
    }

    private void processTouchDown(MotionEvent event) {
        mLastX = event.getX();
        mLastY = event.getY();
        drawView.calcPos(mLastX, mLastY, mTmpPiont);
        float lastConvX = mTmpPiont.x;
        float lastConvY = mTmpPiont.y;
        drawModel.startLine(lastConvX, lastConvY);
    }

    private void processTouchMove(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        drawView.calcPos(x, y, mTmpPiont);
        float newConvX = mTmpPiont.x;
        float newConvY = mTmpPiont.y;
        drawModel.addLineElem(newConvX, newConvY);

        mLastX = x;
        mLastY = y;
        drawView.invalidate();
    }

    private void processTouchUp() {
        drawModel.endLine();
    }

    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}