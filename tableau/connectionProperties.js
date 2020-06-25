(function propertiesbuilder(attr) {
    var props = {};
    props["user"] = attr[connectionHelper.attributeUsername];
    props["password"] = attr[connectionHelper.attributePassword];
//    props["logdir"] = "C:\\Users\\A9406939"; //attr[connectionHelper.attributeLogdir];
    return props;
})
