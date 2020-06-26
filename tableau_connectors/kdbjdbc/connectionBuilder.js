(function dsbuilder(attr) {
    var urlBuilder = "jdbc:log:jdbc:kdb:" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort];
//    var urlBuilder = "jdbc:log:jdbc:sqlite:" + attr[connectionHelper.attributeServer];
//    var urlBuilder = "jdbc:sqlite:" + attr[connectionHelper.attributeServer];

    return [urlBuilder];
})
