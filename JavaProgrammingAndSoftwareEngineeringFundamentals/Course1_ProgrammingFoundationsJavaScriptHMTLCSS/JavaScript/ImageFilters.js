var img_org=0,can;

function NoImg(){
if(img_org==0){
    alert("Please load an image first.");
    }else if(!img_org.complete()){
    alert("Please wait for image upload to complete");
    }
}

function LoadImage(){
    can = document.getElementById("canvas");   
    var ctx = can.getContext("2d");    
    var ImgFile = document.getElementById("LoadImg");
    img_org = new SimpleImage(ImgFile);
    ctx.clearRect(0,0,can.width,can.height);
    img_org.drawTo(can);
}

function resetImage(){
    NoImg();
    var ctx = can.getContext("2d");
    ctx.clearRect(0,0,can.width,can.height);
    img_org.drawTo(can);
}

// blur by moving random pixels
function ensureInImage (coordinate, size) {
  // coordinate cannot be negative
  if (coordinate < 0) {
      return 0;
  }
  // coordinate must be in range [0 .. size-1]
  if (coordinate >= size) {
      return size - 1;
  }
  return coordinate;
}

function getPixelNearby (image, x, y, diameter) {
  var dx = Math.random() * diameter - diameter / 2;
  var dy = Math.random() * diameter - diameter / 2;
  var nx = ensureInImage(x + dx, image.getWidth());
  var ny = ensureInImage(y + dy, image.getHeight());
  return image.getPixel(nx, ny);
}

function makeBlur(){

  can = document.getElementById("canvas");   
  var ctx = can.getContext("2d");
  ctx.clearRect(0,0,can.width,can.height);

  var image = new SimpleImage(img_org);
  var output = new SimpleImage(image.getWidth(), image.getHeight());

  for (var pixel of image.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    if (Math.random() > 0.5) {
        var other = getPixelNearby(image, x, y, 10);
        output.setPixel(x, y, other);
    }
    else {
        output.setPixel(x, y, pixel);
    }
  }
image.drawTo(can);
}


function makeRed(){
    NoImg();
    var ctx = can.getContext("2d");
    ctx.clearRect(0,0,can.width,can.height);
    var img = new SimpleImage(img_org);
    for (var pixel of img.values()){
        pixel.setRed(255);
    }
    img.drawTo(can);
}

function makeGrey(){
    NoImg();
    var ctx = can.getContext("2d");
    ctx.clearRect(0,0,can.width,can.height);
    img = new SimpleImage(img_org);
    for (var px of img.values()){
        var r=px.getRed();
        var g=px.getGreen();
        var b=px.getBlue();
        var avg = (r+g+b)/3;
        px.setRed(avg);
        px.setGreen(avg);
        px.setBlue(avg);
    }
    img.drawTo(can);  
}


function makeRainbow() {
    NoImg();
    var ctx = can.getContext("2d");
    ctx.clearRect(0,0,can.width,can.height);    
    img = new SimpleImage(img_org)
    var height = img.getHeight();
    for (var pixel of img.values()) {
      var y = pixel.getY();
      var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
      if (y < height / 7) {
        //red
        if (avg < 128) {
          pixel.setRed(2 * avg);
          pixel.setGreen(0);
          pixel.setBlue(0);
        } else {
          pixel.setRed(255);
          pixel.setGreen(2 * avg - 255);
          pixel.setBlue(2 * avg - 255);
        }
      } else if (y < height * 2 / 7) {
        //orange
        if (avg < 128) {
          pixel.setRed(2 * avg);
          pixel.setGreen(0.8*avg);
          pixel.setBlue(0);
        } else {
          pixel.setRed(255);
          pixel.setGreen(1.2*avg-51);
          pixel.setBlue(2 * avg - 255);
        }
      } else if (y < height * 3 / 7) {
        //yellow
        if (avg < 128) {
          pixel.setRed(2 * avg);
          pixel.setGreen(2*avg);
          pixel.setBlue(0);
        } else {
          pixel.setRed(255);
          pixel.setGreen(255);
          pixel.setBlue(2 * avg - 255);
        }
      } else if (y < height * 4 / 7) {
        //green
        if (avg < 128) {
          pixel.setRed(0);
          pixel.setGreen(2*avg);
          pixel.setBlue(0);
        } else {
          pixel.setRed(2*avg-255);
          pixel.setGreen(255);
          pixel.setBlue(2 * avg - 255);
        }
      } else if (y < height * 5 / 7) {
        //blue
        if (avg < 128) {
          pixel.setRed(0);
          pixel.setGreen(0);
          pixel.setBlue(2*avg);
        } else {
          pixel.setRed(2*avg-255);
          pixel.setGreen(2 * avg - 255);
          pixel.setBlue(255);
        }
      } else if (y < height * 6 / 7) {
        //indigo
        if (avg < 128) {
          pixel.setRed(.8*avg);
          pixel.setGreen(0);
          pixel.setBlue(2*avg);
        } else {
          pixel.setRed(1.2*avg-51);
          pixel.setGreen(2 * avg - 255);
          pixel.setBlue(255);
        }
      } else {
        //violet
        if (avg < 128) {
          pixel.setRed(1.6*avg);
          pixel.setGreen(0);
          pixel.setBlue(1.6*avg);
        } else {
          pixel.setRed(0.4*avg+153);
          pixel.setGreen(2 * avg - 255);
          pixel.setBlue(0.4*avg+153);
        }
      }
    }
    img.drawTo(can);
  }
  
PrintSize(img_org);
  

