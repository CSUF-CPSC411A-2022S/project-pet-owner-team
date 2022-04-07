package com.example.cpsc411petownerapp;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class HealthTrackerDirections {
  private HealthTrackerDirections() {
  }

  @NonNull
  public static NavDirections actionHealthTrackerToResult() {
    return new ActionOnlyNavDirections(R.id.action_healthTracker_to_result);
  }
}
