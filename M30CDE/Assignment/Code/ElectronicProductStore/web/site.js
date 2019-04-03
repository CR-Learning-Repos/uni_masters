/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    console.log("site file loaded")
    $(".productlist").on("click", ".addproducttocart", function (item, index) {
        console.log("Add Prdocut", item);
        $("#alertModal").find(".modal-body").html("Added to basket")
        $("#alertModal").show(1000);
        $('#alertModal').hide(5000);
    })
})