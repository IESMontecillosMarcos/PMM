package com.example.actividad3;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;

public class Model implements Serializable {

    private String itemName;
    private boolean isSelected;
    private int image;

    public Model(String itemName, boolean isSelected, int image) {
        this.itemName = itemName;
        this.isSelected = isSelected;
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public int getImage() {return image;}
    public void setImage(int images){image = images;}
}