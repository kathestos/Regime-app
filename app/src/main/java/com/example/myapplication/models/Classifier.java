package com.example.myapplication.models;

public interface Classifier {
    String name();

    Classification recognize(final float[] pixels);
}