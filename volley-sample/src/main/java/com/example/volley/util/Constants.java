package com.example.volley.util;

public class Constants {

    public static final String DEFAULT_STRING_REQUEST_URL = "http://www.baidu.com";
    public static final String DEFAULT_JSON_REQUEST_URL = "http://app.api.autohome.com.cn/autov4.3/cars/seriesprice-a2-pm2-v4.3.0-b42-t1.html";
    public static final String DEFAULT_XML_REQUEST_URL = "http://flash.weather.com.cn/wmaps/xml/china.xml";
    public static final String DEFAULT_POST_REQUEST_URL = "webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";

    public static final String[] IMAGE_URLS = new String[]{
            // 小图
            "http://car0.autoimg.cn/upload/2014/10/3/s_20141003015514509-110.jpg",
            "http://car0.autoimg.cn/upload/2014/10/3/s_20141003015436443-110.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522261885926411.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522262753326411.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522264830126410.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522234807726411.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522241219626411.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522223742126411.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522222242926411.jpg",
            "http://car0.autoimg.cn/upload/2014/9/25/s_2014092522212610426410.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090500294461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090453812461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090447744461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090442556461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090430177461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090253967461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090438352461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090433866461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090240472461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090248391461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090243898461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090236347461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090232734461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090228328461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090232734461211.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090228328461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090243898461210.jpg",
            "http://car0.autoimg.cn/upload/2014/9/19/s_20140919090248391461210.jpg",
            "http://car0.autoimg.cn/upload/2014/11/20/s_20141120201111485-111.jpg",
            "http://car0.autoimg.cn/upload/2014/11/20/s_20141120201112764-111.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144602063213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624145217027213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144615854213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144609054213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144556371213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144611439213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144552237213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144552237213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144611439213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624144609054213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/24/s_20140624145217027213.jpg",
            "http://car0.autoimg.cn/upload/2014/6/5/s_201406051622484833765.jpg",
            "http://car0.autoimg.cn/upload/2014/6/5/s_201406051622484373765.jpg",
            "http://car0.autoimg.cn/upload/2014/4/19/s_20140419160042793-1.jpg",
            "http://car0.autoimg.cn/upload/2014/4/19/s_20140419160020342-1.jpg",
            "http://car0.autoimg.cn/upload/2014/4/19/s_20140419160118970-1.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091112527264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091109314264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091107315264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091102775264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091104696264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091057206264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091102340264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091046379264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091050326264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091051670264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091048410264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091053602264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091044369264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091059298264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091055554264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091042448264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091039235264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091041093264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091035896264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091037926264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091032105264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/13/s_20131213091033995264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/4/s_20131204094426483264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/4/s_20131204094422796264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/4/s_20131204094423566264.jpg",
            "http://car0.autoimg.cn/upload/2013/12/4/s_20131204094420284264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091913244264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091914750264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091909313264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091910491264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091905007264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091903081264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091857722264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091859181264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091853713264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091855469264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091850125264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091851756264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091846287264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091847918264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091842044264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091843129264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091836662264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091838246264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091833043264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091834721264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091830680264.jpg",
            "http://car0.autoimg.cn/upload/2013/11/15/s_20131115091828987264.jpg",
            "http://car0.autoimg.cn/upload/2013/9/11/s_20130911023343211-1.jpg",
            "http://car0.autoimg.cn/upload/2013/9/11/s_20130911023337065-1.jpg",
            "http://car0.autoimg.cn/upload/2013/9/11/s_20130911023335895-1.jpg",
            "http://car0.autoimg.cn/upload/2013/9/11/s_20130911023334709-1.jpg",
            "http://car0.autoimg.cn/upload/2013/9/11/s_20130911023333461-1.jpg",
            "http://car0.autoimg.cn/upload/2013/9/11/s_20130911023332291-1.jpg",
            "http://car0.autoimg.cn/upload/2013/9/10/s_20130910194443167264.jpg",
            "http://car0.autoimg.cn/upload/2013/9/10/s_20130910194428238264.jpg",
            "http://car0.autoimg.cn/upload/2013/9/10/s_20130910194436428264.jpg",
            "http://car0.autoimg.cn/upload/2013/8/21/s_20130821073652422264.jpg",
            "http://car0.autoimg.cn/upload/2013/8/21/s_20130821073645230264.jpg",
            "http://car0.autoimg.cn/upload/2013/8/21/s_20130821073643615264.jpg",
            "http://car0.autoimg.cn/upload/2013/8/21/s_20130821073637469264.jpg",
            "http://car0.autoimg.cn/upload/2013/8/21/s_20130821073640082264.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191958289594407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191958147484407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191958023144407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191957495074407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191957327214407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191957029414407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191957220354407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191956111814407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191955380144407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191955499014407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191955596204407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191955237724407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191955079544407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191954574854407.jpg",
            "http://car0.autoimg.cn/upload/2013/2/19/s_201302191954449284407.jpg",
            "http://car0.autoimg.cn/upload/2012/11/23/s_20121123004218160-1.jpg",
            "http://car0.autoimg.cn/upload/2012/11/23/s_20121123004029194-1.jpg",
            "http://car0.autoimg.cn/upload/2012/11/22/s_20121122223300627-1.jpg",
            "http://car0.autoimg.cn/upload/2012/11/22/s_20121122223303014-1.jpg",
            "http://car0.autoimg.cn/upload/2012/11/22/s_20121122223317169-1.jpg",
            "http://car0.autoimg.cn/upload/2012/11/22/s_20121122223313971-1.jpg",
            "http://car0.autoimg.cn/upload/2012/9/28/s_20120928024826408-1.jpg",
            "http://car0.autoimg.cn/upload/2012/9/28/s_20120928024825066-1.jpg",
            "http://car0.autoimg.cn/upload/2012/9/28/s_20120928024557185-1.jpg",
            "http://car0.autoimg.cn/upload/2012/9/28/s_20120928024506197-1.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_2012070516253479233.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_2012070516240563833.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_2012070516235911733.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_2012070516235375133.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_2012070516241202933.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_2012070516234337733.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174633167123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174630370123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174619823123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174617292123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174614463123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174624526123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174627573123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174611588123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174604713123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174559838123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174602463123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174557260123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174554635123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174546057123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174552057123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174548448123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174543057123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174440573123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174540542123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174405526123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101115174402917123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101104175138301123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101104175135957123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155453284264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155454628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155451565264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155449987264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155448174264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155445596264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155443628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155442503264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155439190264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155437956264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155436721264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155434143264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155431112264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155432393264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155429003264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155427643264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155425831264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155424721264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155420518264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155423549264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155415096264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155410987264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155406753264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155404628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155403393264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155358643264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155402003264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155357346264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155355534264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155354112264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155351690264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155350456264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155348628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155346206264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155344971264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155342753264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155343862264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/s_20101014155341643264.jpg",

            // 大图
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155156565264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155157815264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155159018264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155200315264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155201409264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155202393264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155203440264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155204518264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155205971264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155207628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155208737264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155454628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101104175135957123.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155453284264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155451565264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155449987264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155448174264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155445596264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155443628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155442503264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155439190264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155437956264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155436721264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155434143264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155432393264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155431112264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155429003264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155427643264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155425831264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155424721264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155423549264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155420518264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155415096264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155410987264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155406753264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155404628264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155403393264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155402003264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155358643264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155357346264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155355534264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155354112264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155351690264.jpg",
            "http://car0.autoimg.cn/upload/spec/5742/w_20101014155350456264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105110950264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105112622264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105114107264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105109200264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105107357264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105105607264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105103903264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105101372264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105059622264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105056685264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105054919264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105052716264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105051060264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105049169264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105046919264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105043435264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105041747264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024105038403264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092500482264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092458950264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092457513264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092455966264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092454669264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092453075264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092451763264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092450450264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092448872264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092447388264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092445513264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092443919264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092442216264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092440591264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092438872264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092437200264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092435528264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092433810264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092432122264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092430294264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092428607264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092426857264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092425075264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092423216264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092421388264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092419638264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092417935264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092415794264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092414075264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092412372264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092410341264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092408591264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092406888264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092404763264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092402982264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092401200264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092359357264.jpg",
            "http://car0.autoimg.cn/upload/spec/10691/w_20111024092356966264.jpg",

    };

    private Constants() {
    }


    public static class Extra {
        public static final String FRAGMENT_INDEX = "com.grumoon.volleydemo.FRAGMENT_INDEX";
    }

}
