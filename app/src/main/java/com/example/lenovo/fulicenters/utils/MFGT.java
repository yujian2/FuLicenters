package com.example.lenovo.fulicenters.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.lenovo.fulicenters.I;
import com.example.lenovo.fulicenters.R;
import com.example.lenovo.fulicenters.activity.BoutiqueChildActivity;
import com.example.lenovo.fulicenters.activity.CategoryChildActivity;
import com.example.lenovo.fulicenters.activity.CollectsActivity;
import com.example.lenovo.fulicenters.activity.GoodsDetailActivity;
import com.example.lenovo.fulicenters.activity.LoginActivity;
import com.example.lenovo.fulicenters.activity.MainActivity;
import com.example.lenovo.fulicenters.activity.RegisterActivity;
import com.example.lenovo.fulicenters.activity.UpdateNickActivity;
import com.example.lenovo.fulicenters.activity.UserProfileActivity;
import com.example.lenovo.fulicenters.bean.BoutiqueBean;
import com.example.lenovo.fulicenters.bean.CategoryChildBean;

import java.util.ArrayList;


public class MFGT {
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    public static void gotoMainActivity(Activity context){
        startActivity(context, MainActivity.class);
    }
    public static void startActivity(Activity context,Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context,cls);
        startActivity(context,intent);
    }

    public static void gotoGoodsDetailsActivity(Context context, int goodsId){
        Intent intent = new Intent();
        intent.setClass(context, GoodsDetailActivity.class);
        intent.putExtra(I.GoodsDetails.KEY_GOODS_ID,goodsId);
        startActivity(context,intent);
    }

    public static void startActivity(Context context,Intent intent){
          context.startActivity(intent);
          ((Activity)context).overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }


    public static void gotoBoutiqueChildActivity(Context context, BoutiqueBean bean){
        Intent intent = new Intent();
        intent.setClass(context, BoutiqueChildActivity.class);
        intent.putExtra(I.Boutique.CAT_ID,bean);
        startActivity(context,intent);
    }


    public static void gotoCategoryChildActivity(Context context, int catId, String groupName, ArrayList<CategoryChildBean> list){
        Intent intent = new Intent();
        intent.setClass(context, CategoryChildActivity.class);
        intent.putExtra(I.CategoryChild.CAT_ID,catId);
        intent.putExtra(I.CategoryGroup.NAME,groupName);
        intent.putExtra(I.CategoryChild.ID,list);
        startActivity(context,intent);
    }

    public static void gotoLogin(Activity context){
        Intent intent = new Intent();
        intent.setClass(context,LoginActivity.class);
        startActivityForResult(context,intent,I.REQUEST_CODE_LOGIN);
    }

    public static void gotoRegister(Activity context){
        Intent intent = new Intent();
        intent.setClass(context,RegisterActivity.class);
        startActivityForResult(context,intent,I.REQUEST_CODE_REGISTER);
    }


    public static void startActivityForResult(Activity context,Intent intent,int requestCode){
        context.startActivityForResult(intent,requestCode);
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }

    public static void gotoSettings(Activity context){
        startActivity(context, UserProfileActivity.class);
    }

    public static void gotoUpdateNick(Activity context){
        startActivityForResult(context,new Intent(context, UpdateNickActivity.class),I.REQUEST_CODE_NICK);
    }

    public static void gotoCollects(Activity context){
        startActivity(context, CollectsActivity.class);
    }

}