(function dsbuilder(attr) {
//    var urlBuilder = "jdbc:postgresql://" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort] + "/" + attr[connectionHelper.attributeDatabase] + "?";
    var urlBuilder = "jdbc:kdb:" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort];
    var loglevel = attr[connectionHelper.attributeVendor1];
    if(loglevel == "true") {
      urlBuilder = "jdbc:log:" + urlBuilder;
    }
    return [urlBuilder];
})
