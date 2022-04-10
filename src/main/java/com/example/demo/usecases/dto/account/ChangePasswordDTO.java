package com.example.demo.usecases.dto.account;

public class ChangePasswordDTO {
  public String oldPassword;
  public String newPassword;
  public String newPasswordConfirmation;
  public ChangePasswordDTO(
    String oldPassword,
    String newPassword,
    String newPasswordConfirmation
  ) {
    this.oldPassword = oldPassword;
    this.newPassword = newPassword;
    this.newPasswordConfirmation = newPasswordConfirmation;
  }
  public String getOldPassword() {
    return oldPassword;
  }
  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }
  public String getNewPassword() {
    return newPassword;
  }
  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }
  public String getNewPasswordConfirmation() {
    return newPasswordConfirmation;
  }
  public void setNewPasswordConfirmation(String newPasswordConfirmation) {
    this.newPasswordConfirmation = newPasswordConfirmation;
  }
}
