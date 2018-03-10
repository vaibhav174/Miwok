package com.example.bittu.miwok;



public class word {

    public word(String defaultTranslation, String miwokTranslation, int audioId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioId=audioId;
    }
    public word(String defaultTranslation, String miwokTranslation, int resourceId, int audioId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = resourceId;
        mAudioId=audioId;
    }
    /** Default translation for the word */
    private String mDefaultTranslation;

            /** Miwok translation for the word */
            private String mMiwokTranslation;
            /**image resource id variable */
            private int mImageResourceId = noImage;
            private static final int noImage = -1;
            /** audio id */
            private int mAudioId;


            /**
 +     * Get the default translation of the word.
 +     */
            public String getDefaultTranslation() {
                return mDefaultTranslation;
            }

            /**
 +      Get the Miwok translation of the word.
 +     */
            public String getMiwokTranslation() {
                return mMiwokTranslation;
            }
        /** get image resource id */
        public int getImageResourceId(){ return mImageResourceId;}

        public boolean hasImage(){ return mImageResourceId!=noImage;}

        public int getAudioID(){return mAudioId;}
}
