(function dsbuilder(attr) {
//    var urlBuilder = "jdbc:postgresql://" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort] + "/" + attr[connectionHelper.attributeDatabase] + "?";
    var urlBuilder = "jdbc:log:jdbc:kdb:" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort];

    return [urlBuilder];
})
