// Generated by view binder compiler. Do not edit!
package com.example.myapplication2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecyclerZametkiItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView zametkiContentTextView;

  @NonNull
  public final TextView zametkiTitleTextView;

  private RecyclerZametkiItemBinding(@NonNull LinearLayout rootView,
      @NonNull TextView zametkiContentTextView, @NonNull TextView zametkiTitleTextView) {
    this.rootView = rootView;
    this.zametkiContentTextView = zametkiContentTextView;
    this.zametkiTitleTextView = zametkiTitleTextView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecyclerZametkiItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecyclerZametkiItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recycler_zametki_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecyclerZametkiItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.zametki_content_text_view;
      TextView zametkiContentTextView = ViewBindings.findChildViewById(rootView, id);
      if (zametkiContentTextView == null) {
        break missingId;
      }

      id = R.id.zametki_title_text_view;
      TextView zametkiTitleTextView = ViewBindings.findChildViewById(rootView, id);
      if (zametkiTitleTextView == null) {
        break missingId;
      }

      return new RecyclerZametkiItemBinding((LinearLayout) rootView, zametkiContentTextView,
          zametkiTitleTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
