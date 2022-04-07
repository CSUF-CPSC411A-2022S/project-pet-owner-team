package com.example.cpsc411petownerapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LoginDirections {
  private LoginDirections() {
  }

  @NonNull
  public static ActionLoginToMenu actionLoginToMenu(@NonNull String name) {
    return new ActionLoginToMenu(name);
  }

  public static class ActionLoginToMenu implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionLoginToMenu(@NonNull String name) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionLoginToMenu setName(@NonNull String name) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("name")) {
        String name = (String) arguments.get("name");
        __result.putString("name", name);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_login_to_menu;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getName() {
      return (String) arguments.get("name");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionLoginToMenu that = (ActionLoginToMenu) object;
      if (arguments.containsKey("name") != that.arguments.containsKey("name")) {
        return false;
      }
      if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getName() != null ? getName().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionLoginToMenu(actionId=" + getActionId() + "){"
          + "name=" + getName()
          + "}";
    }
  }
}
