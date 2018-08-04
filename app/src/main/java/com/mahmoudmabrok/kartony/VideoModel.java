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
        //list.add(new VideoModel("محمد الفاتح (فتح القسطنطينية)", "dALv4zLU2GY"));
        list.add(new VideoModel("طارق بن زياد (فتح الأندلس)", "TWNGn4okAYs"));
        list.add(new VideoModel("أسد عين جالوت (سيف الدين قطز)", "faFgDwP96bo"));
        list.add(new VideoModel("صقر القوقاز (شامل باسييف)", "Qmfb-All840"));

        list.add(new VideoModel("فارس الأندلس", "B-I-BX6Wt9M"));
        //  list.add(new VideoModel("عثمان الأندلسي", "ntvAWYe3ePM"));
        list.add(new VideoModel("الأسير عروج", "nI5IPLZ5Oyg"));
        //   list.add(new VideoModel("معركة ملاذكر (القائد ألب أرسلان)", "4nBK-rteglk"));
        list.add(new VideoModel("رحلة الخلود (قصة أصحاب الأخدود)", "LUFF6ylV-2Y"));

        list.add(new VideoModel(" فيلم المهند وفريق النينجا (رجل المستحيل)", "2PxLZcft3xg"));
        list.add(new VideoModel(" فيلم الملك خالد", "SBfKxdD94IE"));
        list.add(new VideoModel(" فيلم جزيرة النور", "HhZ8_Vd2aBk"));
        list.add(new VideoModel(" فيلم القراصنة وجزيرة الذهب", "ft_V40qKfhM&t=3s"));
        list.add(new VideoModel(" فيلم سلام والملكة الذهبية", "xRh3GGO9aLg"));
        list.add(new VideoModel(" فيلم البطل نور الدين", "y4mBSokNc_g"));
        list.add(new VideoModel(" فيلم رحلة الأصدقاء", "ZfZveGxwTww"));
        list.add(new VideoModel(" فيلم قرية الزيتون", "-7hi__AEbJM"));
        list.add(new VideoModel(" فيلم السندباد البحري", "aFkYV74iIZk"));
        //  list.add(new VideoModel(" افلام إسلام ويب",""));
        list.add(new VideoModel(" قصص الأنبياء", ""));
        list.add(new VideoModel(" غزوات الرسول عليه السلام", ""));
        list.add(new VideoModel(" فارس الفرات", "aHZk0zSxkaE"));
    /*    list.add(new VideoModel(" صقر القوقاز", "Qmfb-All840"));
        // list.add(new VideoModel(" فيلم كارتون الملك","SBfKxdD94IE"));
        // list.add(new VideoModel(" كارتون قصة أسير","nI5IPLZ5Oyg"));
        // list.add(new VideoModel("القراصنه وكنز الذهب","ft_V40qKfhM"));
        list.add(new VideoModel("نبي الله ابراهيم", "dpSWspL0Bic"));
        // list.add(new VideoModel("فارس الأندلس","B-I-BX6Wt9M"));
        // list.add(new VideoModel("فلم الفاتحون","udX0yiIFbog"));
        list.add(new VideoModel("فيلم كارتون ابن الغابه (قصة حى بن يقظان)", "4CFHemra-RM"));
        list.add(new VideoModel("وفاء الأبطال", "nCUc_TE1Cxc"));
        // list.add(new VideoModel("نبي الله موسى","_ljNFqbyKa8"));
        list.add(new VideoModel("جياد الشرق", "hTgyn6JfUP4"));
        list.add(new VideoModel("نبي الله صالح", "8zCY8nshIDM"));
        list.add(new VideoModel("طريق الحق", ""));
        //list.add(new VideoModel(" محمد الدرة","nrwOsQR0-Fk"));
        list.add(new VideoModel(" القبطان", "cNmBsCFBscM"));
        list.add(new VideoModel(" علي بابا", "TL7CeQtfQt8"));
        list.add(new VideoModel(" جزيرة اللؤلؤ", "DIIN6KgxxQc"));
*/
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
