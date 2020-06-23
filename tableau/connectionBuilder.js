(function dsbuilder(attr) {
    var urlBuilder = "jdbc:kdb:" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort];

    return [urlBuilder];
})
