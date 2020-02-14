package me.levy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sheet extends JPanel {
    private final Dimension SIZE = new Dimension(1200 ,700);
    private  final int UPDATE_RATE = 24;
    private Note note;
    private Thread noteThread;

    public static int w = 5;
    public static int h = 5;

    public static int sheetMusicLineDistance = 50;
    public static int sheetMusicLineDistanceHalf = sheetMusicLineDistance / 2;
    public static int sheetMusicLineDistanceQuarter = sheetMusicLineDistance / 4;
    public static int sheetMusicLineWidth = sheetMusicLineDistance * 19 + w;

    public static int noteBoxX = sheetMusicLineDistance * 4;
    public static int noteBoxWidth = sheetMusicLineWidth;
    public static int noteBoxHeight = sheetMusicLineDistanceHalf;

    public static int notePosVarY = 1;

    public static int getToMiddleOfLine = 3;

    public static int HighBy =  sheetMusicLineDistance * 2 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int HighGy =  sheetMusicLineDistance * 3 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int HighEy =  sheetMusicLineDistance * 4 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int MidCy  =  sheetMusicLineDistance * 5 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int MidAy  =  sheetMusicLineDistance * 6 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int MidFy  =  sheetMusicLineDistance * 7 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int MidDy  =  sheetMusicLineDistance * 8 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;
    public static int LowBy  =  sheetMusicLineDistance * 9 + sheetMusicLineDistanceQuarter + getToMiddleOfLine;

    public static int HighCy = sheetMusicLineDistance * 1 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int HighAy = sheetMusicLineDistance * 2 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int HighFy = sheetMusicLineDistance * 3 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int HighDy = sheetMusicLineDistance * 4 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int MidBy  = sheetMusicLineDistance * 5 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int MidGy  = sheetMusicLineDistance * 6 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int MidEy  = sheetMusicLineDistance * 7 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int LowCy  = sheetMusicLineDistance * 8 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;
    public static int LowAy  = sheetMusicLineDistance * 9 + sheetMusicLineDistanceQuarter + sheetMusicLineDistanceHalf + getToMiddleOfLine;

    // Rectangles for each note

    // Notes with lines
    NoteBox HighB = new NoteBox(noteBoxX, HighBy,noteBoxWidth, noteBoxHeight);
    NoteBox HighG = new NoteBox(noteBoxX, HighGy,noteBoxWidth, noteBoxHeight);
    NoteBox HighE = new NoteBox(noteBoxX, HighEy,noteBoxWidth, noteBoxHeight);
    NoteBox MidC = new NoteBox(noteBoxX, MidCy, noteBoxWidth, noteBoxHeight);
    NoteBox MidA = new NoteBox(noteBoxX, MidAy, noteBoxWidth, noteBoxHeight);
    NoteBox MidF = new NoteBox(noteBoxX, MidFy, noteBoxWidth, noteBoxHeight);
    NoteBox MidD = new NoteBox(noteBoxX, MidDy, noteBoxWidth, noteBoxHeight);
    NoteBox LowB = new NoteBox(noteBoxX, LowBy, noteBoxWidth, noteBoxHeight);

    // Notes without lines
    NoteBox HighC = new NoteBox(noteBoxX, HighCy, noteBoxWidth, noteBoxHeight);
    NoteBox HighA = new NoteBox(noteBoxX, HighAy, noteBoxWidth, noteBoxHeight);
    NoteBox HighF = new NoteBox(noteBoxX, HighFy, noteBoxWidth, noteBoxHeight);
    NoteBox HighD = new NoteBox(noteBoxX, HighDy, noteBoxWidth, noteBoxHeight);
    NoteBox MidB = new NoteBox(noteBoxX, MidBy, noteBoxWidth, noteBoxHeight);
    NoteBox MidG = new NoteBox(noteBoxX, MidGy, noteBoxWidth, noteBoxHeight);
    NoteBox MidE = new NoteBox(noteBoxX, MidEy, noteBoxWidth, noteBoxHeight);
    NoteBox LowC = new NoteBox(noteBoxX, LowCy, noteBoxWidth, noteBoxHeight);
    NoteBox LowA = new NoteBox(noteBoxX, LowAy, noteBoxWidth, noteBoxHeight);

    /**
     * Constructor
     */
    public Sheet() {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if((e.getX() >= HighC.x && e.getX() <= HighC.x + noteBoxWidth)
                        && e.getY() >= HighC.y && e.getY() <= HighC.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High C");
                    notePosVarY = 1;
                }

                else if((e.getX() >= HighB.x && e.getX() <= HighB.x + noteBoxWidth)
                        && e.getY() >= HighB.y && e.getY() <= HighB.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High B");
                    notePosVarY = 2;
                }

                else if((e.getX() >= HighA.x && e.getX() <= HighA.x + noteBoxWidth)
                        && e.getY() >= HighA.y && e.getY() <= HighA.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High A");
                    notePosVarY = 3;
                }

                else if((e.getX() >= HighG.x && e.getX() <= HighG.x + noteBoxWidth)
                        && e.getY() >= HighG.y && e.getY() <= HighG.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High G");
                    notePosVarY = 4;
                }

                else if((e.getX() >= HighF.x && e.getX() <= HighF.x + noteBoxWidth)
                        && e.getY() >= HighF.y && e.getY() <= HighF.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High F");
                    notePosVarY = 5;
                }

                else if((e.getX() >= HighE.x && e.getX() <= HighE.x + noteBoxWidth)
                        && e.getY() >= HighE.y && e.getY() <= HighE.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High E");
                    notePosVarY = 6;
                }

                else if((e.getX() >= HighD.x && e.getX() <= HighD.x + noteBoxWidth)
                        && e.getY() >= HighD.y && e.getY() <= HighD.y + sheetMusicLineDistanceHalf) {
                    System.out.println("High D");
                    notePosVarY = 7;
                }

                else if((e.getX() >= MidC.x && e.getX() <= MidC.x + noteBoxWidth)
                        && e.getY() >= MidC.y && e.getY() <= MidC.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid C");
                    notePosVarY = 8;
                }

                else if((e.getX() >= MidB.x && e.getX() <= MidB.x + noteBoxWidth)
                        && e.getY() >= MidB.y && e.getY() <= MidB.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid B");
                    notePosVarY = 9;
                }

                else if((e.getX() >= MidA.x && e.getX() <= MidA.x + noteBoxWidth)
                        && e.getY() >= MidA.y && e.getY() <= MidA.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid A");
                    notePosVarY = 10;
                }

                else if((e.getX() >= MidG.x && e.getX() <= MidG.x + noteBoxWidth)
                        && e.getY() >= MidG.y && e.getY() <= MidG.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid G");
                    notePosVarY = 11;
                }

                else if((e.getX() >= MidF.x && e.getX() <= MidF.x + noteBoxWidth)
                        && e.getY() >= MidF.y && e.getY() <= MidF.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid F");
                    notePosVarY = 12;
                }

                else if((e.getX() >= MidE.x && e.getX() <= MidE.x + noteBoxWidth)
                        && e.getY() >= MidE.y && e.getY() <= MidE.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid E");
                    notePosVarY = 13;
                }

                else if((e.getX() >= MidD.x && e.getX() <= MidD.x + noteBoxWidth)
                        && e.getY() >= MidD.y && e.getY() <= MidD.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Mid D");
                    notePosVarY = 14;
                }

                else if((e.getX() >= LowC.x && e.getX() <= LowC.x + noteBoxWidth)
                        && e.getY() >= LowC.y && e.getY() <= LowC.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Low C");
                    notePosVarY = 15;
                }

                else if((e.getX() >= LowB.x && e.getX() <= LowB.x + noteBoxWidth)
                        && e.getY() >= LowB.y && e.getY() <= LowB.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Low B");
                    notePosVarY = 16;
                }

                else if((e.getX() >= LowA.x && e.getX() <= LowA.x + noteBoxWidth)
                        && e.getY() >= LowA.y && e.getY() <= LowA.y + sheetMusicLineDistanceHalf) {
                    System.out.println("Low A");
                    notePosVarY = 17;
                }

                else {
                    System.out.println("Out of bounds");
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Note.click++;
                Note.drawNoteIsTrue++;
            }
        });

        setPreferredSize(SIZE);
        note = new Note(SIZE);
        noteThread = new Thread() {
            public void run() {
                while (true) {
                    note.move();
                    repaint();

                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) { }
                }
            }
        };
        noteThread.start();
    }

    /**
     * Paint Component
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D p = (Graphics2D) g;

        // background color
        p.setColor(Color.LIGHT_GRAY);
        p.fillRect(0, 0, getWidth(), getHeight());

        // Drawing Grid
        g.setColor(Color.gray);
        for(int i = 0; i < 1200; i += sheetMusicLineDistance) {
            for(int j = 0; j < 700; j += sheetMusicLineDistance) {
                g.fillRect(i, j, 5,5);
            }
        }
        g.setColor(Color.darkGray);
        for(int a = 4; a < 9; a++) {
            g.fillRect(noteBoxX,sheetMusicLineDistance * a,sheetMusicLineWidth, h);
        }

        // drawing note rectangles
        g.setColor(Color.magenta);
        g.drawRect(noteBoxX, HighC.y, sheetMusicLineWidth, HighC.h);
        g.drawRect(noteBoxX, HighB.y, sheetMusicLineWidth, HighB.h);
        g.drawRect(noteBoxX, HighA.y, sheetMusicLineWidth, HighA.h);
        g.drawRect(noteBoxX, HighG.y, sheetMusicLineWidth, HighG.h);
        g.drawRect(noteBoxX, HighF.y, sheetMusicLineWidth, HighF.h);
        g.drawRect(noteBoxX, HighE.y, sheetMusicLineWidth, HighE.h);
        g.drawRect(noteBoxX, HighD.y, sheetMusicLineWidth, HighD.h);
        g.drawRect(noteBoxX, MidC.y, sheetMusicLineWidth, MidC.h);
        g.drawRect(noteBoxX, MidB.y, sheetMusicLineWidth, MidB.h);
        g.drawRect(noteBoxX, MidA.y, sheetMusicLineWidth, MidA.h);
        g.drawRect(noteBoxX, MidG.y, sheetMusicLineWidth, MidG.h);
        g.drawRect(noteBoxX, MidF.y, sheetMusicLineWidth, MidF.h);
        g.drawRect(noteBoxX, MidE.y, sheetMusicLineWidth, MidE.h);
        g.drawRect(noteBoxX, MidD.y, sheetMusicLineWidth, MidD.h);
        g.drawRect(noteBoxX, LowC.y, sheetMusicLineWidth, LowC.h);
        g.drawRect(noteBoxX, LowB.y, sheetMusicLineWidth, LowB.h);
        g.drawRect(noteBoxX, LowA.y, sheetMusicLineWidth, LowA.h);

        // draw note
        note.paint(p);
    }
}
