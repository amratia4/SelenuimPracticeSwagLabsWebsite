package e2eScenarioSwagLab;

import baseSwagLab.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesSwagLab.*;

public class E2EScenario extends BaseTests {

    String selectedProductName;
    String selectedProductPrice;
    @Test

    public void E2EScenarioTest(){

        ProductsPage products = new ProductsPage(driver);
        Assert.assertEquals(products.getAppLogo(),"Swag Labs");
        SelectedProductPage selectedProduct = products.clickFirstProduct();
        Assert.assertEquals(products.getFirstProductName(),selectedProduct.getSelectedProductName());
        selectedProductName = selectedProduct.getSelectedProductName();
        selectedProductPrice = selectedProduct.getSelectedProductPrice();
        selectedProduct.clickAddToCartButton();
        Assert.assertEquals(selectedProduct.getRemoveButton(),"Remove");
        Assert.assertNotNull(selectedProduct.getShoppingCartBadgeNumber());
        YourCartPage cartPage = selectedProduct.clickShoppingCartBadge();
        Assert.assertEquals(cartPage.getProductNameCart(),selectedProductName);
        Assert.assertEquals(cartPage.getProductPriceCart(),selectedProductPrice);
        CheckoutInformationPage infoPage = cartPage.clickCheckoutButton();
        infoPage.enterFName("firstName");
        infoPage.enterLName("lastName");
        infoPage.enterPostalCode("1234TS");
        CheckoutOverviewPage overviewPage= infoPage.clickContinueButton();
        Assert.assertEquals(overviewPage.getProductNameCheckoutOverviewPage(),selectedProductName);
        Assert.assertEquals(overviewPage.getProductPriceCheckoutOverview(),selectedProductPrice);
        Assert.assertNotNull(overviewPage.getTax());
        Assert.assertNotNull(overviewPage.getTotalPrice());
        CheckoutCompletePage completePage = overviewPage.clickFinishButton();
        Assert.assertEquals(completePage.getSuccessMessage(),"Thank you for your order!");


    }




}
