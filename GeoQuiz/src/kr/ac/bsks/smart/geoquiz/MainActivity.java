package kr.ac.bsks.smart.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	
	private TrueFalse[] mQuestionBank = new TrueFalse[] { 
			new TrueFalse( R.string.question_oceans, true ),
			new TrueFalse( R.string.question_mideast, true ),
			new TrueFalse( R.string.question_africa, true ),
			new TrueFalse( R.string.question_americas, true ),
			new TrueFalse( R.string.question_asia, true ),
	} ;
    
	private int mCurrentIndex = 0;
	
	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText( question );
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText( question );
		
		
		mTrueButton = (Button) findViewById(R.id.true_button);
		mTrueButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), R.string.incorrect_toast , Toast.LENGTH_SHORT).show();
			}
		});
		
		mFalseButton = (Button) findViewById(R.id.false_button);
		mFalseButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
			}
		});
		
		mNextButton = (Button) findViewById(R.id.next_button);
		mNextButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = ( mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		updateQuestion();
		
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

 
}
