package com.gurudattdahare.paint.EventManneger;

import android.graphics.Bitmap;

public interface OnEventsListener {
    public void OnRedClicked();
    public void OnBlueClicked();
    public void OnYellowClicked();
    public  void OnGreenClicked();
    public void OnBlackClicked();
    public void OnBrownClicked();
    public void OnEraserClicked();
    public void OnClearClicked();
    public void OnBrushSizeClicked();
    public void OnUndoClicked();
    public void OnRedoclicked();
    public void OnSaveClicked(Bitmap bitmap);
}

