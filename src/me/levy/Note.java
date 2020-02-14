package me.levy;

import java.awt.*;

public class Note {
    private Dimension screenSize;
    private Color noteStable;
    private Color noteOnPlay;
    private int noteWidth;
    private int noteHeight;
    private Point speed;
    private Point location;


    public int posY;
    public int posX = 50 * 4 + (50 / 4);

    public int drawNoteY = 50 * 2;

    public static int click = 0;
    public static int drawNoteIsTrue = 0;

    public int noteDrawPos = 0;

    /**
     * Constructor
     */
    public Note(Dimension screenSize) {
        this.screenSize = screenSize;
        noteStable = new Color(35, 35, 35);
        noteOnPlay = new Color(198,0, 59);
        noteWidth = 28;
        noteHeight = Sheet.noteBoxHeight;
        speed = new Point(0, 5);
        location = new Point();
    }

    public void move() {
        location.x = 50 * 4 + (50/4);
        switch (Sheet.notePosVarY) {
            case 1:
                location.y = Sheet.HighCy;
                noteDrawPos = 1;
                break;
            case 2:
                location.y = Sheet.HighBy;
                noteDrawPos = 2;
                break;
            case 3:
                location.y = Sheet.HighAy;
                noteDrawPos = 3;
                break;
            case 4:
                location.y = Sheet.HighGy;
                noteDrawPos = 4;
                break;
            case 5:
                location.y = Sheet.HighFy;
                noteDrawPos = 5;
                break;
            case 6:
                location.y = Sheet.HighEy;
                noteDrawPos = 6;
                break;
            case 7:
                location.y = Sheet.HighDy;
                noteDrawPos = 7;
                break;
            case 8:
                location.y = Sheet.MidCy;
                noteDrawPos = 8;
                break;
            case 9:
                location.y = Sheet.MidBy;
                noteDrawPos = 9;
                break;
            case 10:
                location.y = Sheet.MidAy;
                noteDrawPos = 10;
                break;
            case 11:
                location.y = Sheet.MidGy;
                noteDrawPos = 11;
                break;
            case 12:
                location.y = Sheet.MidFy;
                noteDrawPos = 12;
                break;
            case 13:
                location.y = Sheet.MidEy;
                noteDrawPos = 13;
                break;
            case 14:
                location.y = Sheet.MidDy;
                noteDrawPos = 14;
                break;
            case 15:
                location.y = Sheet.LowCy;
                noteDrawPos = 15;
                break;
            case 16:
                location.y = Sheet.LowBy;
                noteDrawPos = 16;
                break;
            case 17:
                location.y = Sheet.LowAy;
                noteDrawPos = 17;
                break;
            default:
                break;

        }
        location.setLocation(location.x, location.y);

        // Note Movement to the left
        if(click == 1) {
            location.x += 50;
        } else if(click == 2) {
            location.x += 100;
        } else if(click == 3) {
            location.x += 150;
        } else if(click == 4) {
            location.x += 200;
        } else if(click == 5) {
            location.x += 250;
        } else if(click == 6) {
            location.x += 300;
        } else if(click == 7) {
            location.x += 350;
        } else if(click == 8) {
            location.x += 400;
        } else if(click == 9) {
            location.x += 450;
        } else if(click == 10) {
            location.x += 500;
        } else if(click == 11) {
            location.x += 550;
        } else if(click == 12) {
            location.x += 600;
        } else if(click == 13) {
            location.x += 650;
        } else if(click == 14) {
            location.x += 700;
        } else if(click == 15) {
            location.x += 750;
        } else if(click == 16) {
            location.x += 800;
        } else if(click == 17) {
            location.x += 850;
        } else if(click == 18) {
            location.x += 900;
        } else {
            click = 0;
        }
    }

    public void paint(Graphics2D p) {
        p.setColor(noteStable);
        p.fillOval(location.x, location.y, noteWidth, noteHeight);

        switch (Sheet.notePosVarY) {
            case 1:
                drawNoteY = Sheet.HighCy;
                break;
            case 2:
                drawNoteY = Sheet.HighBy;
                break;
            case 3:
                drawNoteY = Sheet.HighAy;
                break;
            case 4:
                drawNoteY = Sheet.HighGy;
                break;
            case 5:
                drawNoteY = Sheet.HighFy;
                break;
            case 6:
                drawNoteY = Sheet.HighEy;
                break;
            case 7:
                drawNoteY = Sheet.HighDy;
                break;
            case 8:
                drawNoteY = Sheet.MidCy;
                break;
            case 9:
                drawNoteY = Sheet.MidBy;
                break;
            case 10:
                drawNoteY = Sheet.MidAy;
                break;
            case 11:
                drawNoteY = Sheet.MidGy;
                break;
            case 12:
                drawNoteY = Sheet.MidFy;
                break;
            case 13:
                drawNoteY = Sheet.MidEy;
                break;
            case 14:
                drawNoteY = Sheet.MidDy;
                break;
            case 15:
                drawNoteY = Sheet.LowCy;
                break;
            case 16:
                drawNoteY = Sheet.LowBy;
                break;
            case 17:
                drawNoteY = Sheet.LowAy;
                break;
        }

        if(drawNoteIsTrue >= 1) {
            p.fillOval(50 * 4 + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 2) {
            p.fillOval(50 * 5  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 3) {
            p.fillOval(50 * 6  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 4) {
            p.fillOval(50 * 7  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 5) {
            p.fillOval(50 * 8  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 6) {
            p.fillOval(50 * 9  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 7) {
            p.fillOval(50 * 10  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 8) {
            p.fillOval(50 * 11  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 9) {
            p.fillOval(50 * 12  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 10) {
            p.fillOval(50 * 13 + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 11) {
            p.fillOval(50 * 14 + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 12) {
            p.fillOval(50 * 15  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 13) {
            p.fillOval(50 * 16  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 14) {
            p.fillOval(50 * 17  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 15) {
            p.fillOval(50 * 18  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 16) {
            p.fillOval(50 * 19  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 17) {
            p.fillOval(50 * 20  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 18) {
            p.fillOval(50 * 21  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
        if(drawNoteIsTrue >= 19) {
            p.fillOval(50 * 22  + (50 / 4), drawNoteY, noteWidth, noteHeight);
        }
    }

    // Getters

    public Color getNoteStable() {
        return noteStable;
    }

    public Color getNoteOnPlay() {
        return noteOnPlay;
    }

    public int getNoteWidth() {
        return noteWidth;
    }

    public int getNoteHeight() {
        return noteHeight;
    }

    public Point getSpeed() {
        return speed;
    }

    public Point getLocation() {
        return location;
    }
}
