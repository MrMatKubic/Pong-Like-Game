package com.matkubik.test;

import javax.swing.*;

import com.matkubik.test.loader.ImageLoader;

import java.awt.*;

public class Window extends Canvas
{
    private static final long serialVersionUID = -2408406005337283541L;

    public Window(int width, int height, String title, Game game)
    {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(ImageLoader.loadImage("/textures/bloc.png"));
        frame.add(game);

        frame.setVisible(true);
        game.start();
    }

}
