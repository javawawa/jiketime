<!DOCTYPE html>
<html>
<head>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>

    <title>${columnCollectorResponse.column_title}</title>
    <style type="text/css">
        html, body {
            margin: 0px;
            padding: 0px;
            width: 100%;
            height: 100%;
            font-size: 14px;
        }

        .con_left {
            float: left;
            width: 350px;
            height: 100%;
            overflow: scroll;
        }

        .con_right {
            margin-left: 350px;
            height: 100%;
            overflow: scroll;
        }

        .con-rigth-in {
            padding: 10px;
        }

        #content_api {
            padding: 10px;
        }

        .head_title {
            text-align: center;
            font-size: 24px;
            margin: 10px;
            font-weight: bold;
        }

        .ol_apis {
            padding: 5px;
            font-family: tahoma, Arial, Microsoft YaHei, \5b8b\4f53;
            list-style: none;
        }

        .ol_apis li {
            background: #eee;
            border-radius: 5px;
            margin-bottom: 5px;
            padding: 5px;
        }

        .ol_apis a {
            display: inline-block;
            text-decoration: none;
        }

        .ol_apis a:hover {
            color: #F90;
        }

        .ol_apis .api_title {
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
            display: block;
        }

        .ol_api.selected {
            background: #FF9400;
            color: #FFF;
        }

        .fun_comment {
            background: #f3f5f7;
        }

        .float_r {
            float: right;
        }

        .hidden {
            display: none;
        }

        .clear_both {
            clear: both;
        }

        #con_right {
            padding: 10px;
        }

        #article_title {
            font-size: 24px;
            font-weight: bold;
            line-height: 30px;
        }

        #audio_download_url {
            color: #CC0000;
        }

        #videomp3 {
            height: 50px;
            width: 400px;
        }

        #article_content {
            font-size: 14px;
        }

        #article_content img{
            max-width: 60%;
        }

        code{
            font-size: .8rem;
            font-family: Consolas,Liberation Mono,Menlo,monospace,Courier;
            display: block;
            width: 100%;
            box-sizing: border-box;
            /* padding-left: 1rem; */
            /* padding-right: 1rem; */
            overflow-x: auto;
            background: hsla(0,0%,97%,.7);
            border: 1px solid #ddd;
            padding: 1em 1.5em;
        }
    </style>
    <script type="text/javascript">
        var articleList = ${articleCollectorResponseListJson};

        $(function () {
            var html = "";
            for (var i = 0; i < articleList.length; i++) {
                var article = articleList[i];
                var id = article["id"];
                var article_title = article["article_title"];
                var article_content = article["article_content"];
                var audio_download_url = article["audio_download_url"];
                html += "<li class=\"ol_api\">" +
                        "                <div>" +
                        "                    <span class=\"api_title\" article_id=\"" + id + "\">" + article_title + "</span>" +
                        "                    <div class=\"clear_both\"></div>" +
                        "                </div>" +
                        "            </li>";
            }
            $("#ol_apis").html(html);

            $(".api_title").click(function () {
                var tar = $(this);
                $(".ol_api").removeClass("selected");
                var article_id = tar.attr("article_id");
                for (var i = 0; i < articleList.length; i++) {
                    var article = articleList[i];
                    var id = article["id"];
                    if (id == article_id) {
                        var article_title = article["article_title"];
                        var article_content = article["article_content"];
                        var audio_download_url = article["audio_download_url"];
                        var site_source_url = article["site_source_url"];
                        $("#article_title").attr("href",site_source_url).html(article_title);
                        var video = '<video id="videomp3" src="' + audio_download_url + '" autoplay="autoplay" preload="none" controls="controls"></video>';
                        $("#audio_download_url").html(video);
                        $("#article_content").html(article_content);
                    }
                }

            });
        });
    </script>
</head>
<body>
<div class="con_left">
    <div style="padding:10px;">
        <div style="color: #CC0000; font-size:18px; font-weight: bold; text-align: center">${columnCollectorResponse.column_title}</div>
        <ol class="ol_apis" id="ol_apis">
        </ol>
    </div>
</div>
<div class="con_right">
    <div id="con_right">
        <div><a href="" target="_blank" id="article_title"></a></div>
        <div id="audio_download_url"></div>
        <div id="article_content"></div>
    </div>
</div>
</body>
</html>