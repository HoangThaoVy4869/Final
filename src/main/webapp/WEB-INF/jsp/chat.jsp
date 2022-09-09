<%-- 
    Document   : chat
    Created on : Aug 17, 2022, 1:02:21 AM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="module" src="<c:url value="/resources/js/chat.js"/>"></script>
<link href="<c:url value="/resources/css/chat.css"/>" rel='stylesheet'>
<div class="container-fluid h-100">
    <div class="row justify-content-center h-100">
        <div class="col-md-4 col-xl-3 chat">
            <div class="card mb-sm-3 mb-md-0 contacts_card">
                <div class="card-header">
                    <div class="input-group">
                        <input type="text" placeholder="Search..." name="" class="form-control search">
                        <div class="input-group-prepend">
                            <span class="input-group-text search_btn"><i class="fas fa-search"></i></span>
                        </div>
                    </div>
                </div>
                <div class="card-body contacts_body">
                    <ui class="contacts">
                        <li class="active">
                            <div class="d-flex bd-highlight">
                                <div class="img_cont">
                                    <img src="https://res.cloudinary.com/ou/image/upload/v1638804121/wuuhs7jd3d2lag6nmv9w.jpg"
                                         class="rounded-circle user_img">
                                    <span class="online_icon"></span>
                                </div>
                                <div class="user_info">
                                    <span>CTao Zi</span>
                                    <p>CTao Zi đang online</p>
                                </div>
                            </div>
                        </li>

                        <li class="active">
                            <div class="d-flex bd-highlight">
                                <div class="img_cont">
                                    <img src="https://res.cloudinary.com/ou/image/upload/v1641957797/jcwon0uju3mhcmlwoute.jpg"
                                         class="rounded-circle user_img">
                                    <span class="online_icon"></span>
                                </div>
                                <div class="user_info">
                                    <span>Hóng hớt</span>
                                    <p>Hóng hớt đang online</p>
                                </div>
                            </div>
                        </li>


                        <li class="active">
                            <div class="d-flex bd-highlight">
                                <div class="img_cont">
                                    <img src="https://res.cloudinary.com/ou/image/upload/v1638696847/tbvs9ywrtiei4np9fiwz.png"
                                         class="rounded-circle user_img">
                                    <span class="online_icon"></span>
                                </div>
                                <div class="user_info">
                                    <span>tRầM cẢm vÌ dEaLiNe</span>
                                    <p>tRầM cẢm vÌ dEaLiNe đang online</p>
                                </div>
                            </div>
                        </li>


                    </ui>
                </div>
                <div class="card-footer"></div>
            </div>
        </div>
        <div class="col-md-8 col-xl-6 chat">
            <div class="card">
                <div class="card-header msg_head">
                    <div class="d-flex bd-highlight">
                        <div class="img_cont">
                            <img src="https://res.cloudinary.com/ou/image/upload/v1642169611/urszmn2h69pfeg17i9mx.png"
                                 class="rounded-circle user_img">
                            <span class="online_icon"></span>
                        </div>
                        <div class="user_info">
                            <span>Nhóm hôm nay là thứ pảy</span>
                            <p>Members: 5</p>
                        </div>
                        <div class="video_cam">
                            <span><i class="fas fa-video"></i></span>
                            <span><i class="fas fa-phone"></i></span>
                        </div>
                    </div>
                    <span id="action_menu_btn"><i class="fas fa-ellipsis-v"></i></span>
                </div>
                <div class="card-body msg_card_body" id="bodyContent">


                </div>
                <div class="card-footer">
                    <div class="input-group">
                        <div class="input-group-append">
                            <span class="input-group-text attach_btn"><i class="fas fa-paperclip"></i></span>
                        </div>
                        <textarea name="message" id="message" class="form-control type_msg"
                                  placeholder="Type your message..."></textarea>
                        <div class="input-group-append">
                            <button id="submit" class="input-group-text send_btn"><i class="fas fa-location-arrow"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#action_menu_btn').click(function () {
            $('.action_menu').toggle();
        });
    });
</script>
<div class="col-1">
    <a href="<c:url value="/user/list"/>"><button class="btn btn-warning">Back</button></a>
</div>