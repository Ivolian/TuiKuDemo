package com.example.administrator.tuikudemo.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.tuikudemo.Fragment.ArticleFragment;
import com.example.administrator.tuikudemo.Fragment.HotFragment;
import com.example.administrator.tuikudemo.Fragment.OfflineFragment;
import com.example.administrator.tuikudemo.Fragment.SettingFragment;
import com.example.administrator.tuikudemo.Fragment.SiteFragment;
import com.example.administrator.tuikudemo.Fragment.TopicFragment;
import com.example.administrator.tuikudemo.R;
import com.github.johnpersano.supertoasts.SuperToast;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    /**
     * 旋转屏幕 recreate 会重建 fragments，而且原先 hide 的 fragment 会被 show
     */

    // ============================ tags ============================

    final String ARTICLE = "Article";
    final String HOT = "hot";
    final String TOPIC = "topic";
    final String SITE = "site";
    final String OFFLINE = "offline";
    final String SETTING = "setting";

    // ============================ fields ============================

    String currentTag;

    Toolbar toolbar;

    DrawerLayout drawerLayout;

    long exitTime;

    // ============================ onCreate ============================

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbarAndDrawerLayout();
        addOnClickListenersForSideMenu();

        // onCreate
        if (savedInstanceState == null) {
            initFirstFragment();
        }

        // onRecreate
        else {
            selectSideMenuItemByTag(savedInstanceState.getString("currentTag"));
        }
    }

    private void initToolbarAndDrawerLayout() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");  // 这一个无奈的 bug
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void addOnClickListenersForSideMenu() {

        findViewById(R.id.rl_left_article).setOnClickListener(this);
        findViewById(R.id.rl_left_article_hot).setOnClickListener(this);
        findViewById(R.id.rl_left_topic).setOnClickListener(this);
        findViewById(R.id.rl_left_site).setOnClickListener(this);
        findViewById(R.id.rl_left_search).setOnClickListener(this);
        findViewById(R.id.rl_left_offline).setOnClickListener(this);
        findViewById(R.id.rl_left_setting).setOnClickListener(this);
    }

    private void initFirstFragment() {

        String tag = HOT;
        addFragment(getFragmentByTag(tag));
        selectSideMenuItemByTag(tag);
    }

    // ============================ onBackPressed ============================

    @Override
    public void onBackPressed() {

        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToastMessage("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    // ============================ onSaveInstanceState ============================

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString("currentTag", currentTag);
    }

    // ============================ onClick ============================

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rl_left_article:
                onSideMenuItemClick(ARTICLE);
                break;

            case R.id.rl_left_article_hot:
                onSideMenuItemClick(HOT);
                break;

            case R.id.rl_left_topic:
                onSideMenuItemClick(TOPIC);
                break;

            case R.id.rl_left_site:
                onSideMenuItemClick(SITE);
                break;

            case R.id.rl_left_search:
                showDialogMessage("提示", "搜索功能不打算开发。");
                break;

            case R.id.rl_left_offline:
                onSideMenuItemClick(OFFLINE);
                break;

            case R.id.rl_left_setting:
                onSideMenuItemClick(SETTING);
                break;
        }
    }

    // ============================ high-level functions ============================

    private void onSideMenuItemClick(String tag) {

        replaceFragment(getFragmentByTag(tag));
        drawerLayout.closeDrawers();
        selectSideMenuItemByTag(tag);
    }

    private void selectSideMenuItemByTag(String tag) {

        unSelectCurrentSideMenuItem();

        // 设置背景色，图标，文字和标题
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(getRelativeLayoutIdByTag(tag));
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
        ImageView imageView = (ImageView) relativeLayout.getChildAt(0);
        imageView.setBackgroundResource(getIconResourceByTag(tag, true));
        TextView textView = (TextView) relativeLayout.getChildAt(1);
        textView.setTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle(getToolbarTitleByTag(tag));

        currentTag = tag;
    }

    private void unSelectCurrentSideMenuItem() {

        if (currentTag == null) {
            return;
        }

        // 还原背景，图标，文字和标题
        RelativeLayout current = (RelativeLayout) findViewById(getRelativeLayoutIdByTag(currentTag));
        current.setBackgroundResource(R.drawable.drawer_menu_selector);
        ImageView imageView = (ImageView) current.getChildAt(0);
        imageView.setBackgroundResource(getIconResourceByTag(currentTag, false));
        TextView textView = (TextView) current.getChildAt(1);
        textView.setTextColor(getResources().getColor(R.color.black));
        toolbar.setTitle(getToolbarTitleByTag(currentTag));
    }

    // ============================ byTag functions ============================

    private Fragment getFragmentByTag(String tag) {
        switch (tag) {
            case ARTICLE:
                return new ArticleFragment();
            case HOT:
                return new HotFragment();
            case TOPIC:
                return new TopicFragment();
            case SITE:
                return new SiteFragment();
            case OFFLINE:
                return new OfflineFragment();
            case SETTING:
                return new SettingFragment();
            default:
                throw new RuntimeException("getFragmentByTag: wrong tag");
        }
    }

    private int getIconResourceByTag(String tag, Boolean selected) {

        switch (tag) {
            case ARTICLE:
                return selected ? R.drawable.left_article_selected : R.drawable.left_article;
            case HOT:
                return selected ? R.drawable.left_article_hot_selected : R.drawable.left_article_hot;
            case TOPIC:
                return selected ? R.drawable.left_topic_selected : R.drawable.left_topic;
            case SITE:
                return selected ? R.drawable.left_site_selected : R.drawable.left_site;
            case OFFLINE:
                return selected ? R.drawable.left_offline_selected : R.drawable.left_offline;
            case SETTING:
                return selected ? R.drawable.left_setting_selected : R.drawable.left_setting;
            default:
                throw new RuntimeException("getRelativeLayoutIdByTag: wrong tag");
        }
    }

    private int getRelativeLayoutIdByTag(String tag) {

        switch (tag) {
            case ARTICLE:
                return R.id.rl_left_article;
            case HOT:
                return R.id.rl_left_article_hot;
            case TOPIC:
                return R.id.rl_left_topic;
            case SITE:
                return R.id.rl_left_site;
            case OFFLINE:
                return R.id.rl_left_offline;
            case SETTING:
                return R.id.rl_left_setting;
            default:
                throw new RuntimeException("getRelativeLayoutIdByTag: wrong tag");
        }
    }

    private String getToolbarTitleByTag(String tag) {

        switch (tag) {
            case ARTICLE:
                return "推荐文章";
            case HOT:
                return "发现文章";
            case TOPIC:
                return "我的主题";
            case SITE:
                return "我的站点";
            case OFFLINE:
                return "离线阅读";
            case SETTING:
                return "相关设置";
            default:
                throw new RuntimeException("getToolbarTitleByTag: wrong tag");
        }

    }

    // ============================ fragment functions ============================

    private void addFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).commit();
    }

    private void replaceFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }

    // ============================ message functions ============================

    private void showDialogMessage(String title, String message) {

        NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);
        dialogBuilder
                .withDialogColor("#1DE9B6")
                .withEffect(Effectstype.Shake)
                .withTitle(title)
                .withMessage(message)
                .show();
    }

    private void showCroutonMessage(String message) {

        ViewGroup root = (ViewGroup) getLayoutInflater().inflate(R.layout.crouton_custom_view, null);
        TextView textView = (TextView) root.getChildAt(0);
        textView.setText(message);

        Configuration configuration = new Configuration.Builder().setDuration(1200).build();
        Crouton crouton = Crouton.make(this, root, R.id.croutonContainer, configuration);
        crouton.show();
    }

    private void showToastMessage(String message) {

        SuperToast superToast = new SuperToast(this);
        superToast.setText(message);
        superToast.setBackground(SuperToast.Background.GRAY);
        superToast.setTextColor(Color.WHITE);
        superToast.show();
    }

    // ============================ onDestroy ============================

    @Override
    protected void onDestroy() {
        // Workaround until there's a way to detach the Activity from Crouton while
        // there are still some in the Queue.
        Crouton.clearCroutonsForActivity(this);
        super.onDestroy();
    }

}
