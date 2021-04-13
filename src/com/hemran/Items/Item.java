package com.hemran.Items;

public interface Item {

    public String getContent();

    public void setContent(String content);

    public Priority getPriority();

    public void setPriority(Priority p);

    public boolean isChecked();

    public void setChecked(boolean checked);

    public String highlight();

}
