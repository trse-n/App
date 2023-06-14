// Generated by view binder compiler. Do not edit!
package com.example.myapplication2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PlantsItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView plantsTitle;

  @NonNull
  public final LinearLayout plantsclr;

  private PlantsItemBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView,
      @NonNull TextView plantsTitle, @NonNull LinearLayout plantsclr) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.plantsTitle = plantsTitle;
    this.plantsclr = plantsclr;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PlantsItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PlantsItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.plants_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PlantsItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.plantsTitle;
      TextView plantsTitle = ViewBindings.findChildViewById(rootView, id);
      if (plantsTitle == null) {
        break missingId;
      }

      id = R.id.plantsclr;
      LinearLayout plantsclr = ViewBindings.findChildViewById(rootView, id);
      if (plantsclr == null) {
        break missingId;
      }

      return new PlantsItemBinding((ConstraintLayout) rootView, cardView, plantsTitle, plantsclr);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
