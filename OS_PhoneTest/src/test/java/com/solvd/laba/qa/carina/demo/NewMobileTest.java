package com.solvd.laba.qa.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

public class NewMobileTest implements IAbstractTest, IMobileUtils {

  @Test()
  @MethodOwner(owner = "cezeokeke")
  @TestLabel(name = "feature", value = {"mobile", "regression"})
  public void testWebView() {

  }

  @Test()
  @MethodOwner(owner = "cezeokeke")
  @TestLabel(name = "feature", value = {"mobile", "acceptance"})
  public void testUIElements() {

  }

}
