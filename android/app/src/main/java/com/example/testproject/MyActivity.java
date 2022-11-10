package com.example.testproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.Map;

public class MyActivity extends AppCompatActivity {


    TextView textViewCare, textViewNews, textViewHome, textViewCom, textViewMy, textviewName, textViewEmail;
    ImageView imageViewCare, imageViewNews, imageViewHome, imageViewCom, imageViewMy;

    TextView textView3,textView5;

    private DatabaseReference mDatabase;
    //파이어베이스에 데이터를 추가나 조회하기 위해 사용
    private FirebaseAuth firebaseAuth;


    ListView myListView;
    ListAdapter listAdapter = null;


    ArrayList<String> arr_uid = null;
    ArrayList<String> arr_board_key = null;


    String uid, username;
    Button buttonToProfile;

    String board_uid;
    String board_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        textViewCare = findViewById(R.id.textViewCare);
        textViewNews = findViewById(R.id.textViewNews);
        textViewCom = findViewById(R.id.textViewCom);
        textViewMy = findViewById(R.id.textViewMy);
        textViewHome = findViewById(R.id.textViewHome);

        imageViewCare = findViewById(R.id.imageViewCare);
        imageViewNews = findViewById(R.id.imageViewNews);
        imageViewCom = findViewById(R.id.imageViewCom);
        imageViewMy = findViewById(R.id.imageViewMy);
        imageViewHome = findViewById(R.id.imageViewHome);

        textViewEmail = findViewById(R.id.my_email);
        textviewName = findViewById(R.id.my_name);
        //textViewRevise = findViewById(R.id.button);

        textView3 = findViewById(R.id.textView3);

        textView5 = findViewById(R.id.textView5);

        buttonToProfile =findViewById(R.id.buttonToPro);

        myListView = (ListView) findViewById(R.id.list_myListView);
        listAdapter = new ListAdapter();

        board_uid = getIntent().getStringExtra("arr_uid"); // intent 로 넘어오는 값을 세팅함
        board_key = getIntent().getStringExtra("arr_board_key");


        arr_uid = new ArrayList<>();
        arr_board_key = new ArrayList<>();

        MyActivity.ListListener listListener = new MyActivity.ListListener();
        myListView.setOnItemClickListener(listListener);


        getBoard();



        uid = user.getUid();

        mDatabase.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);




                textviewName.setText(user.name + "님");
                textViewEmail.setText(user.email);

               /* username = (String) textviewName.getText();
                textView3.setText(username);*/

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        buttonToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);


            }
        });


        textViewCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CareActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageViewCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CareActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imageViewCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textViewCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void getBoard() {


        mDatabase.child("board").child("text").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Map<String, String> map = (Map) dataSnapshot.getValue();
                myListView.setAdapter(listAdapter);

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        Board board = snapshot.getValue(Board.class);

                        //User user = snapshot.getValue(User.class);
                        //mDatabase.child("board").child("text").child(uid).child(board.getUid()).child(snapshot.getKey());
                        //mDatabase.child("board").child("text").child(uid).child(board.getUid());


                            textView3.setText(board.getUid());
                            textView5.setText(uid);



                        arr_uid.add(board.getUid());
                        arr_board_key.add(snapshot.getKey());

                        listAdapter.addItem(board.getTitle(), board.getDate(), board.getName(), board.getClick());


                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    class ListListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent i = new Intent(MyActivity.this, ReadBoardActivity.class);
            i.putExtra("arr_uid", arr_uid.get(position));
            i.putExtra("arr_board_key", arr_board_key.get(position));
            startActivity(i);

        }
    }



}