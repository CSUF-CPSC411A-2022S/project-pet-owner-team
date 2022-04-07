package com.example.cpsc411petownerapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MenuArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MenuArgs() {
  }

  @SuppressWarnings("unchecked")
  private MenuArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MenuArgs fromBundle(@NonNull Bundle bundle) {
    MenuArgs __result = new MenuArgs();
    bundle.setClassLoader(MenuArgs.class.getClassLoader());
    if (bundle.containsKey("name")) {
      String name;
      name = bundle.getString("name");
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("name", name);
    } else {
      throw new IllegalArgumentException("Required argument \"name\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getName() {
    return (String) arguments.get("name");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("name")) {
      String name = (String) arguments.get("name");
      __result.putString("name", name);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    MenuArgs that = (MenuArgs) object;
    if (arguments.containsKey("name") != that.arguments.containsKey("name")) {
      return false;
    }
    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MenuArgs{"
        + "name=" + getName()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(MenuArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String name) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
    }

    @NonNull
    public MenuArgs build() {
      MenuArgs result = new MenuArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setName(@NonNull String name) {
      if (name == null) {
        throw new IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("name", name);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getName() {
      return (String) arguments.get("name");
    }
  }
}
