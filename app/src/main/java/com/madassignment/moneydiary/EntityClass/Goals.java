package com.madassignment.moneydiary.EntityClass;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Goal")
public class Goals {

    @PrimaryKey(autoGenerate = true)
    private int goalId;

    @ColumnInfo(name = "Title")
    private String goalTitle;

    @ColumnInfo(name = "Due")
    private String goalDue;

    @ColumnInfo(name = "Media")
    private Byte[] goalMedia;

    @ColumnInfo(name = "Balance")
    private float goalBalance;

    public int getGoalId() {
        return goalId;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public String getGoalDue() {
        return goalDue;
    }

    public void setGoalDue(String goalDue) {
        this.goalDue = goalDue;
    }

    public Byte[] getGoalMedia() {
        return goalMedia;
    }

    public void setGoalMedia(Byte[] goalMedia) {
        this.goalMedia = goalMedia;
    }

    public float getGoalBalance() {
        return goalBalance;
    }

    public void setGoalBalance(float goalBalance) {
        this.goalBalance = goalBalance;
    }
}
