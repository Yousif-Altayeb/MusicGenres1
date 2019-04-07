package com.example.yousif.musicgenres;

/**
 * Created by Yousif on 1/10/2019.
 */

public class Songs {

    private String mSongName;
    private String mSongDesc;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private int mAudioRisourceId;


    private static final int NO_IMAGE_PROVIDED = -1;

    public Songs(String songName, String songDesc){
        mSongName = songName;
        mSongDesc = songDesc;

    }


    public Songs(String songName, String songDesc, int AudioResourceId){
        mSongName = songName;
        mSongDesc = songDesc;
        mAudioRisourceId = AudioResourceId;
    }

    public Songs(String songName, String songDesc,int ImageResourceId, int AudioResourceId){
        mSongName = songName;
        mSongDesc = songDesc;
        mImageResourceID = ImageResourceId;
        mAudioRisourceId = AudioResourceId;
    }

    public Songs(String songName){
        mSongName = songName;
    }

    public String getmSongName(){
        return  mSongName;
    }

    public String getmSongDesc(){
        return mSongDesc;
    }

    public int getmImageResourceID() {
        return mImageResourceID;
    }

    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;

    }

    public  int getmAudioRisourceId(){
        return mAudioRisourceId;
    }

}
