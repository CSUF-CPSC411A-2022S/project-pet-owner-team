// Generated by view binder compiler. Do not edit!
package com.example.cpsc411petownerapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cpsc411petownerapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ResultBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout frameLayout;

  @NonNull
  public final TextView resultText;

  private ResultBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout frameLayout,
      @NonNull TextView resultText) {
    this.rootView = rootView;
    this.frameLayout = frameLayout;
    this.resultText = resultText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ResultBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ResultBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.result, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ResultBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout frameLayout = (ConstraintLayout) rootView;

      id = R.id.resultText;
      TextView resultText = ViewBindings.findChildViewById(rootView, id);
      if (resultText == null) {
        break missingId;
      }

      return new ResultBinding((ConstraintLayout) rootView, frameLayout, resultText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
