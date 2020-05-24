package com.cloud.justyou.util.voice.Speech_sound;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Cycle_Speech {
    private static Integer num = null;

    private static Sample sample_2;

    private static String str_1;  //按专业查询时的专业名

    private static Integer judge = 0;  //判断是否为语音标识


    public static Integer getJudge() {
        return judge;
    }

    public static String getStr_1() {
        return str_1;
    }


    public static void Cycle_Speech_body() throws JSONException, InterruptedException, SQLException {
        //语音助手提示信息
        jacobtest jaco = new jacobtest();
        jaco.textToSpeech("欢迎使用Tiko语音助手，请问有什么可以帮您的");

        Sample sample = new Sample();
        sample.main(null);

        num = new Sample().getIndex();

        while(num == 1)
        {
//            if(sample.getResult() == null)
//            {
//                new jacobtest().textToSpeech("对不起,我没听清你说的话");
//                continue;
//            }

            if(sample.getResult().contains("打开音乐")||sample.getResult().contains("音乐打开")||
                    sample.getResult().contains("音乐响起来")||sample.getResult().contains("燥起来")||
                    sample_2.getResult().contains("打开音乐")||sample_2.getResult().contains("音乐打开")||
                    sample_2.getResult().contains("音乐响起来")||sample_2.getResult().contains("燥起来"))
            {
                AudioPlayer audio = new AudioPlayer(new File("D:\\java2\\不将就.mp3"));
                audio.start();
                break;
            }
            else if(sample.getResult().contains("常规查询")||sample.getResult().contains("一般查询")||
                    sample.getResult().contains("信息查询")||sample.getResult().contains("查询信息")||
                    sample_2.getResult().contains("常规查询")||sample_2.getResult().contains("一般查询")||
                    sample_2.getResult().contains("信息查询")||sample_2.getResult().contains("查询信息"))
            {
                new Demo().Found_normal();
                break;
            }
            else if(sample.getResult().contains("总分降序查询")||sample.getResult().contains("总分降序")||
                    sample.getResult().contains("总降序")||
                    sample_2.getResult().contains("总分降序查询")||sample_2.getResult().contains("总分降序")||
                    sample_2.getResult().contains("总降序"))
            {
                new Demo().total_down();
                break;
            }
            else if(sample.getResult().contains("总分升序查询")||sample.getResult().contains("总分升序")||
                    sample.getResult().contains("总升序")||
                    sample_2.getResult().contains("总分升序查询")||sample_2.getResult().contains("总分升序")||
                    sample_2.getResult().contains("总升序"))
            {
                new Demo().total_up();
                break;
            }
            else if(sample.getResult().contains("数学降序查询")||sample.getResult().contains("数学降序")||
                    sample.getResult().contains("数降序")||
                    sample_2.getResult().contains("数学降序查询")||sample_2.getResult().contains("数学降序")||
                    sample_2.getResult().contains("数降序"))
            {
                new Demo().math_down();
                break;
            }
            else if(sample.getResult().contains("政治降序查询")||sample.getResult().contains("政治降序")||
                    sample.getResult().contains("政降序")||
                    sample_2.getResult().contains("政治降序查询")||sample_2.getResult().contains("政治降序")||
                    sample_2.getResult().contains("政降序"))
            {
                new Demo().poli_down();
                break;
            }
            else if(sample.getResult().contains("英语降序查询")||sample.getResult().contains("英语降序")||
                    sample.getResult().contains("英降序")||
                    sample_2.getResult().contains("英语降序查询")||sample_2.getResult().contains("英语降序")||
                    sample_2.getResult().contains("英降序"))
            {
                new Demo().eng_down();
                break;
            }
            else if(sample.getResult().contains("按专业查询")||sample_2.getResult().contains("按专业查询")||
                    sample.getResult().contains("专业查询")||sample_2.getResult().contains("专业查询"))
            {
                jacobtest jacobtest = new jacobtest();
                jaco.textToSpeech("请问您要查询的专业名称是什么");
                Sample sample_1 = new Sample();
                sample_1.main(null);

                //去除字符串中的标点
                str_1 = format(sample_1.getResult());

                //设置语音判断标识
                judge = 1;

                new Demo().found_major_content();

                //还原判断值
                judge = 0;

                break;

            }

            else if(sample.getResult().contains("bbox")||sample.getResult().contains("bboss")||
                    sample_2.getResult().contains("bbox")||sample_2.getResult().contains("bboss"))
            {
                jacobtest jacobtest = new jacobtest();
                jaco.textToSpeech("哎呀！我不会，不过没关系，嘿Siri，来一段beatbox");
                break;
            }

            else if(sample.getResult().contains("背景一")||sample.getResult().contains("背景1")
                    ||sample.getResult().contains("NBA背景")||sample.getResult().contains("nba背景")||
                    sample_2.getResult().contains("背景一")||sample_2.getResult().contains("背景1")
                    ||sample_2.getResult().contains("NBA背景")||sample_2.getResult().contains("nba背景"))
            {
                new Demo().background_1();

                break;
            }
            else if(sample.getResult().contains("背景二")||sample.getResult().contains("背景2")||
                    sample_2.getResult().contains("背景二")||sample_2.getResult().contains("背景2"))
            {
                new Demo().background_2();
                break;
            }
            else if(sample.getResult().contains("背景三")||sample.getResult().contains("背景3")||
                    sample_2.getResult().contains("背景三")||sample_2.getResult().contains("背景3"))
            {
                new Demo().background_3();
                break;
            }
            else if(sample.getResult().contains("背景四")||sample.getResult().contains("背景4")||
                    sample_2.getResult().contains("背景四")||sample_2.getResult().contains("背景4"))
            {
                new Demo().background_4();
                break;
            }
            else if(sample.getResult().contains("滚")||sample.getResult().contains("拜拜")||
                    sample.getResult().contains("再见")||sample.getResult().contains("爬开")||
                    sample_2.getResult().contains("滚")||sample_2.getResult().contains("拜拜")||
                    sample_2.getResult().contains("再见")||sample_2.getResult().contains("爬开"))
            {
                new jacobtest().textToSpeech("好的");
                break;
            }
            else if(sample.getResult().contains("放个屁")||sample_2.getResult().contains("放个屁"))
            {
                new jacobtest().textToSpeech("噗噗噗噗，噗噗噗");
                break;
            }
            else if(sample.getResult().contains("打开QQ")||sample.getResult().contains("QQ")||
                    sample_2.getResult().contains("打开QQ")||sample_2.getResult().contains("QQ"))
            {
                try {

                    Process p = Runtime.getRuntime().exec("C:\\Program Files\\tencent\\QQ\\Bin\\QQ.exe");
                    System.err.println("p===="+p.getInputStream());

                } catch (IOException ex1)
                {
                    ex1.printStackTrace();
                }
                break;
            }
            else if(sample.getResult().contains("打开优酷")||sample.getResult().contains("优酷")||
                    sample_2.getResult().contains("打开优酷")||sample_2.getResult().contains("优酷"))
            {
                try {

                    Process p = Runtime.getRuntime().exec("D:\\Program Files (x86)\\YouKu\\YoukuClient\\proxy\\YoukuDesktop.exe");
                    System.err.println("p===="+p.getInputStream());

                } catch (IOException ex1)
                {
                    ex1.printStackTrace();
                }
                break;
            }
            else
            {
                new jacobtest().textToSpeech("我好像没有听懂您的意思,能再说一次吗？");
                sample_2 = new Sample();
                sample_2.main(null);

                continue;
            }
        }

    }


    //去除字符串中的标点
    public static String format(String s){
        String str=s.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& amp;*（）——+|{}【】‘；：”“’。，、？|-]", "");
        return str;
    }
}
