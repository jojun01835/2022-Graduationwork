package com.example.testproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class ReadBoardActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference mDatabase;
    String uid;

    TextView textView_read_board_contentType2, textView_read_board_writer2, textView_read_board_title2, textView_read_board_content, textView_read_board_date2, textView_read_board_click2;
    String board_uid;
    String board_key;
    Map board_content_type;
    ImageView imageViewBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_board);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        uid = user.getUid();

        imageViewBackBtn = findViewById(R.id.backbtn);


        textView_read_board_contentType2 = (TextView) findViewById(R.id.textView_read_board_content); // 컨텐츠 타입으로 적힐것
        textView_read_board_writer2 = (TextView) findViewById(R.id.textView_read_board_writer); // 작성자
        textView_read_board_title2 = (TextView) findViewById(R.id.textView_read_board_title); // 제목
        textView_read_board_content = (TextView) findViewById(R.id.textView_read_board_content); // 내욜
        textView_read_board_date2 = (TextView) findViewById(R.id.textView_read_board_date); // 날짜
        textView_read_board_click2 = (TextView) findViewById(R.id.textView_read_board_click); // 조회수
        board_uid = getIntent().getStringExtra("arr_uid"); // intent 로 넘어오는 값을 세팅함
        board_key = getIntent().getStringExtra("arr_board_key");

        board_type(); // 게시판 속성 정의
        board_set(); // 화면 구성 시작

        imageViewBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }




    public void board_type() {
        mDatabase.child("boardType").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Log.d("data_snap", "" + dataSnapshot);
                //board_content_type = (Map) dataSnapshot.getValue();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void board_set() {
        mDatabase.child("board").child("text").child(board_uid).child(board_key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("data_snap", "" + dataSnapshot);
                Board board = dataSnapshot.getValue(Board.class);

                mDatabase.child("board").child("text").child(board_uid).child(board_key).child("click").setValue(board.getClick()+1);

                //textView_read_board_contentType2.setText((Integer) board_content_type.get(board.getContentType()));
                textView_read_board_writer2.setText(board.getName());
                textView_read_board_title2.setText(board.getTitle());
                textView_read_board_date2.setText(board.getDate());
                textView_read_board_content.setText(board.getContent());
                textView_read_board_click2.setText(String.valueOf(board.getClick()));

                textView_read_board_content.setMovementMethod(new ScrollingMovementMethod()); // TextView가 스크롤이 생김


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}

