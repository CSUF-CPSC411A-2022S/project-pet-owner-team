package com.example.cpsc411petownerapp;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class MenuDirections {
  private MenuDirections() {
  }

  @NonNull
  public static NavDirections actionMenuToHealthTracker() {
    return new ActionOnlyNavDirections(R.id.action_menu_to_healthTracker);
  }

  @NonNull
  public static NavDirections actionMenuToInfo2() {
    return new ActionOnlyNavDirections(R.id.action_menu_to_info2);
  }
}
