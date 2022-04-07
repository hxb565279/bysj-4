package com.hxb.demo10.handller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.hxb.demo10.bean.IDBean;
import com.hxb.demo10.bean.USABean;
import com.hxb.demo10.service.DataService;
import com.hxb.demo10.util.HttpURLConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Component
public class DataHandler2 {
    @Autowired
    private DataService dataService;

    public static String url_getId = "https://c.m.163.com/ug/api/wuhan/app/data/list-total?t=329858664502";
    public static String url2 = "https://c.m.163.com/ug/api/wuhan/app/data/list-by-area-code?areaCode=7&t=1649265425913";
    public static String urlStr2 = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_foreign";
    public static String urlStr3 = "https://file1.dxycdn.com/2020/0315/553/3402160512808052518-135.json?t=27488247";
    public static String urlStr4 = "https://ncov.dxy.cn/ncovh5/view/pneumonia";

    public static String httpGet(String vurl) throws IOException {
        try {
            URL url = new URL(vurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            for (Map.Entry item : map.entrySet()) {
//                connection.setRequestProperty(item.getKey().toString(), item.getValue().toString());//设置header
//            }
            InputStream in = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            isr.close();
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static List<USABean> getData() throws IOException {
        HashMap<String, Object> tmap = new HashMap<String, Object>();
//        tmap.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Mobile Safari/537.36");
        String respJson = httpGet(urlStr3);
        String respJson2 = httpGet(urlStr4);
        Gson gson = new Gson();
//        Map map = gson.fromJson(respJson, Map.class);


//        ArrayList<USABean> subStr = (ArrayList<USABean>) gson.get("data");

        List<USABean> result = new ArrayList<>();
//        ArrayList areaList = (ArrayList) subMap.get("areaTree");

//        for (int i = subStr.size()-1; i > subStr.size() - 15; i--) {
//            Map tmp = (Map) subStr.get(i);
//            Double conform = (Double) tmp.get("confirmCount");
//            Double dead = (Double) tmp.get("deadCount");
//            Double heal = (Double) tmp.get("healCount");
//            Date data = (Date) tmp.get("dataId");
//
//
//            USABean usaBean = new USABean(i, conform, dead, heal, data);
//            result.add(usaBean);
//        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
       getData();
    }
}
