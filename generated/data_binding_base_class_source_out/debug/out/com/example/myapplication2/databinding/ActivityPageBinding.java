// Generated by view binder compiler. Do not edit!
package com.example.myapplication2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnexit;

  @NonNull
  public final Button btnmain;

  @NonNull
  public final Button btnzametki;

  @NonNull
  public final RecyclerView categoryRecycler;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final RecyclerView plantsRecycler;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  private ActivityPageBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnexit,
      @NonNull Button btnmain, @NonNull Button btnzametki, @NonNull RecyclerView categoryRecycler,
      @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView2,
      @NonNull RecyclerView plantsRecycler, @NonNull TextView textView3,
      @NonNull TextView textView4) {
    this.rootView = rootView;
    this.btnexit = btnexit;
    this.btnmain = btnmain;
    this.btnzametki = btnzametki;
    this.categoryRecycler = categoryRecycler;
    this.constraintLayout = constraintLayout;
    this.imageView2 = imageView2;
    this.plantsRecycler = plantsRecycler;
    this.textView3 = textView3;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnexit;
      Button btnexit = ViewBindings.findChildViewById(rootView, id);
      if (btnexit == null) {
        break missingId;
      }

      id = R.id.btnmain;
      Button btnmain = ViewBindings.findChildViewById(rootView, id);
      if (btnmain == null) {
        break missingId;
      }

      id = R.id.btnzametki;
      Button btnzametki = ViewBindings.findChildViewById(rootView, id);
      if (btnzametki == null) {
        break missingId;
      }

      id = R.id.categoryRecycler;
      RecyclerView categoryRecycler = ViewBindings.findChildViewById(rootView, id);
      if (categoryRecycler == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.plantsRecycler;
      RecyclerView plantsRecycler = ViewBindings.findChildViewById(rootView, id);
      if (plantsRecycler == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new ActivityPageBinding((ConstraintLayout) rootView, btnexit, btnmain, btnzametki,
          categoryRecycler, constraintLayout, imageView2, plantsRecycler, textView3, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
