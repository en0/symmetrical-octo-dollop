package com.ilaird.learning.day2.ui;

public interface Menu {
    void showMenu();
    void addMenuItem(String label, Runnable command);
}

