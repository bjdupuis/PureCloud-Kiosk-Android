package com.awmdev.purecloudkiosk.View.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.awmdev.purecloudkiosk.Presenter.LoginPresenter;
import com.awmdev.purecloudkiosk.Presenter.LoginPresenterInterface;
import com.awmdev.purecloudkiosk.R;

public class LoginFragment extends Fragment implements View.OnClickListener
{
    private LoginPresenterInterface loginPresenter;
    private EditText userEditText;
    private EditText passwordEditText;
    private TextView errorText;
    private Button loginButton;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //create the presenter and pass the view it is associated with
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //grab the layout associated with this view
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment_login,container,false);
        //grab all of the associated object from the layout
        loginButton = (Button)layout.findViewById(R.id.flogin_login_button);
        userEditText = (EditText)layout.findViewById(R.id.flogin_user_edit);
        passwordEditText = (EditText)layout.findViewById(R.id.flogin_password_edit);
        errorText = (TextView)layout.findViewById(R.id.flogin_error_text);
        //register the onclick listener for the button
        loginButton.setOnClickListener(this);
        //return to the view
        return layout;
    }

    public void setError(int resourceID)
    {
        //set the error from a pre-made string
        errorText.setText(resourceID);
    }

    public void removeErrorText()
    {
        errorText.setText(null);
    }

    @Override
    public void onClick(View v)
    {
        loginPresenter.validateCredentials(userEditText.getText().toString(),passwordEditText.getText().toString());
    }

}
