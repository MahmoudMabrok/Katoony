package com.mahmoudmabrok.kartony;

import java.util.ArrayList;

public class VideoModel {

    private String title;

    private String video_url;


    public VideoModel(String title, String video_url) {
        this.title = title;
        this.video_url = video_url;
    }

    public VideoModel() {

    }

    public static ArrayList<VideoModel> getList() {
        ArrayList<VideoModel> list = new ArrayList<>();

        list.add(new VideoModel("الناصر صلاح الدين (فتح القدس)", "wnNA94tOmGw"));
        list.add(new VideoModel("محمد الفاتح (فتح القسطنطينية)", "dALv4zLU2GY"));
        list.add(new VideoModel("طارق بن زياد (فتح الأندلس)", "TWNGn4okAYs"));
        list.add(new VideoModel("أسد عين جالوت (سيف الدين قطز)", "faFgDwP96bo"));
        list.add(new VideoModel("صقر القوقاز (شامل باسييف)", "Qmfb-All840"));

        list.add(new VideoModel("فارس الأندلس", "B-I-BX6Wt9M"));
        list.add(new VideoModel("عثمان الأندلسي", "ntvAWYe3ePM"));
        list.add(new VideoModel("الأسير عروج", "nI5IPLZ5Oyg"));
        list.add(new VideoModel("معركة ملاذكر (القائد ألب أرسلان)", "4nBK-rteglk"));
        list.add(new VideoModel("رحلة الخلود (قصة أصحاب الأخدود)", "LUFF6ylV-2Y"));

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
