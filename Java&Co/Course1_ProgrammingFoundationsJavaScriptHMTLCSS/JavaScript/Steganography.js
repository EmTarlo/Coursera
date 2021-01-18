var imgTgt,canTgt,imgHide,canHide,fImage,canF,canExtr1,canExtr2;

function loadTgtImage(){
    var img_file = document.getElementById("i1");
    imgTgtOrg = new SimpleImage(img_file);
    imgTgt = new SimpleImage(img_file);
    canTgt = document.getElementById("c1");
    var ctx = canTgt.getContext("2d");    
    var cw = canTgt.width;
    var ch = canTgt.height; 
    ctx.clearRect(0,0,cw,ch);     
    //imgTgt.setSize(cw,ch);
    imgTgt.drawTo(canTgt);
}

function loadToHideImage(){
    var img_file = document.getElementById("i2");
    canHide = document.getElementById("c2");
    var cw = canHide.width;
    var ch = canHide.height;
    var ctx = canHide.getContext("2d");
    ctx.clearRect(0,0,cw,ch);
    imgHideOrg = new SimpleImage(img_file);
    imgHide = new SimpleImage(img_file);
    imgHide.drawTo(canHide);
}

function resetTgtImg(){
    var ctx = canTgt.getContext("2d");
    var cw =canTgt.width;
    var ch =canTgt.height;
    ctx.clearRect(0,0,cw,ch);
    imgTgtOrg.drawTo(canTgt);
}

function resetHideImg(){
    var ctx = canHide.getContext("2d");
    var cw =canHide.width;
    var ch =canHide.height;
    ctx.clearRect(0,0,cw,ch);
    imgHideOrg.drawTo(canHide);
}

function toFourSigDigits(rgb_value){
    var nvalue = Math.floor(rgb_value/16)*16;
    return(nvalue);
}

function shiftFourSigDigits(rgb_value){
    var nvalue = Math.floor(rgb_value/16);
    return(nvalue);
}

function chopHideHelper(img,can){
    var ctx = can.getContext("2d");
    ctx.clearRect(0,0,can.width,can.height);
    for (var px of img.values()){
        var r = px.getRed();
        var nr = toFourSigDigits(r);
        px.setRed(nr);
        var g = px.getGreen();
        var ng = toFourSigDigits(g);
        px.setGreen(ng);
        var b = px.getBlue();
        var nb = toFourSigDigits(b);
        px.setBlue(nb);
    }
    img.drawTo(can);
}

function shiftHideHelper(img,can){
    var ctx = can.getContext("2d");
    ctx.clearRect(0,0,can.width,can.height);
    for (var px of img.values()){
        var r = px.getRed();
        var nr = shiftFourSigDigits(r);
        px.setRed(nr);
        var g = px.getGreen();
        var ng = shiftFourSigDigits(g);
        px.setGreen(ng);
        var b = px.getBlue();
        var nb = shiftFourSigDigits(b);
        px.setBlue(nb);
    }
    img.drawTo(can);
}

function mergeHideHelper(tgt_img,hide_img){
    canF = document.getElementById("c3");
    ctx = canF.getContext("2d");
    ctx.clearRect(0,0,canF.width,canF.height);
    fImage = new SimpleImage(tgt_img.getWidth(),tgt_img.getHeight());
    for (var px of fImage.values()){
        var x = px.getX();
        var y = px.getY();
        tgtPx = tgt_img.getPixel(x,y);
        hidePx = hide_img.getPixel(x,y);
        var nR = tgtPx.getRed() + hidePx.getRed();
        var nG = tgtPx.getGreen() + hidePx.getGreen();
        var nB = tgtPx.getBlue() + hidePx.getBlue();
        px.setRed(nR);
        px.setGreen(nG);
        px.setBlue(nB);
    }
    fImage.drawTo(canF);
}


function extractImgsHelper(img){
    canExtr1 = document.getElementById("c4");
    canExtr2 = document.getElementById("c5");
    ctxExtr1 = canExtr1.getContext("2d");
    ctxExtr2 = canExtr2.getContext("2d");
    ctxExtr1.clearRect(0,0,canExtr1.width,canExtr1.height);
    ctxExtr2.clearRect(0,0,canExtr2.width,canExtr2.height);
    
    var w = img.getWidth();
    var h = img.getHeight();
    var tgtImg = new SimpleImage(w,h);
    var hiddenImg = new SimpleImage(w,h);
    for(var px of img.values()){
        var x = px.getX();
        var y = px.getY();
        tgtImgPx = tgtImg.getPixel(x,y);
        hiddenImgPx = hiddenImg.getPixel(x,y);
        tgtRed =  toFourSigDigits(px.getRed());
        hiddenRed = px.getRed()%16*16;
        tgtGreen =  toFourSigDigits(px.getGreen());
        hiddenGreen = px.getGreen()%16*16;
        tgtBlue =  toFourSigDigits(px.getBlue());
        hiddenBlue = px.getBlue()%16*16;
        tgtImgPx.setRed(tgtRed); 
        tgtImgPx.setGreen(tgtGreen);     
        tgtImgPx.setBlue(tgtBlue);   
        hiddenImgPx.setRed(hiddenRed);
        hiddenImgPx.setGreen(hiddenGreen);
        hiddenImgPx.setBlue(hiddenBlue);
    }

    tgtImg.drawTo(canExtr1);
    hiddenImg.drawTo(canExtr2);
}

function chopHide(){
    chopHideHelper(imgTgt,canTgt);
}

function sigDigShift(){
    shiftHideHelper(imgHide,canHide);
}

function mergeHide(){
    mergeHideHelper(imgTgt,imgHide);
}

function extractImgs(){
    extractImgsHelper(fImage);
}

