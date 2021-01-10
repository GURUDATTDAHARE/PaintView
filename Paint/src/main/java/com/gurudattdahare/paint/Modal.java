package com.gurudattdahare.paint;

import android.graphics.Paint;
import android.graphics.Path;

public class Modal {
    private Paint paint;
    private Path path;

    public Modal(Paint paint, Path path) {
        this.paint = paint;
        this.path = path;
    }

    public Modal() {
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
