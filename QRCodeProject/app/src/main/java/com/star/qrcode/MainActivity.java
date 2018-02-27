package com.star.qrcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.star.qrcode.utils.QRCodeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.url)
    EditText mUrl;
    @BindView(R.id.start)
    Button mStart;
    @BindView(R.id.img)
    ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void onViewClicked() {
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int widthHeight = (int) (outMetrics.widthPixels * 0.5);
        Bitmap qrCodeBitmap = QRCodeUtil.createQRCodeBitmap(mUrl.getText().toString(), widthHeight);
        mImg.setImageBitmap(qrCodeBitmap);
    }
}
