package com.mahmoudmabrok.kartony;

import java.util.ArrayList;

public class VideoModel {

    private String title;

    private String video_url;


    public VideoModel(String title, String video_url) {
        this.title = title;
        this.video_url = video_url;
    }

    public static ArrayList<VideoModel> getList() {
        ArrayList<VideoModel> list = new ArrayList<>();
        list.add(new VideoModel("عثمان الأندلسي", "1tHeYjmJIpc"));
        list.add(new VideoModel("طارق بن زياد (فتح الأندلس)", "TWNGn4okAYs"));
        list.add(new VideoModel("فيلم المهند وفريق النينجا (رجل المستحيل)", "2PxLZcft3xg"));
        list.add(new VideoModel("فيلم الملك خالد", "SBfKxdD94IE"));
        list.add(new VideoModel("فيلم البطل نور الدين", "y4mBSokNc_g"));
        list.add(new VideoModel("فيلم قرية الزيتون", "-7hi__AEbJM"));
        list.add(new VideoModel("فيلم كارتون الملك", "SBfKxdD94IE"));
        list.add(new VideoModel("القراصنه وكنز الذهب", "ft_V40qKfhM"));
        list.add(new VideoModel("فيلم كارتون ابن الغابه (قصة حى بن يقظان)", "4CFHemra-RM"));
        list.add(new VideoModel("جياد الشرق", "hTgyn6JfUP4"));
        list.add(new VideoModel("القبطان", "cNmBsCFBscM"));
        list.add(new VideoModel("القائد ألب أرسلان", "m1z7ot2c9fM"));
        return list;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return video_url;
    }

    public void setMessage(String video_url) {
        this.video_url = video_url;
    }
}
