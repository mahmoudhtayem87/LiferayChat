<%@ include file="/init.jsp" %>

<script type="text/javascript">

		var notification_audio = new Audio('<%= request.getContextPath() %>/alerts/toast_sound.mp3');
</script>
<style>
	.liferay-chat-container
	{
		height: 100% !important;
		width: 100% !important;
	}
	@media (min-width: 768px)
	{
		.sidebar.liferay-chat-container
		{
			width: 100% !important;
		}
	}
		.liferay-chat-container .contacts-list
	{
		max-height: 50vh!important;
		min-height: 50vh!important;
		overflow-y: auto!important;
	}
	.liferay-chat-container .contacts-list .avatar
	{
		border-radius: 100%;
		height: 3rem;
	}
	.online-avatar
	{
		border-color: var(--success) !important;
		border-width: 2px!important;
		border-style: solid!important;
	}
	.offline-avatar
	{
		border-color: var(--danger) !important;
		border-width: 2px!important;
		border-style: solid!important;
	}

	/* Style name text */
	.name
	{
		font-size: smaller;
		color:var(--primary);
	}
	.chatPanel .chat .name-right {
		float: right;
		color: #aaa;
	}
	.chatPanel .chat .name-left {
		float: left;
		color:var(--secondary);
	}

	.LrChat {
		width: 100%;
		max-width: 100%;
		height: 35vh;
		min-height: 100%;
		margin: 0 auto;
		overflow-y: scroll;
		transform: rotate(180deg);
		direction: rtl;
	}
	.LrChat__wrapper {
		display: -webkit-box;
		display: -ms-flexbox;
		display: flex;
		-webkit-box-orient: vertical;
		-webkit-box-direction: normal;
		-ms-flex-direction: column-reverse;
		flex-direction: column-reverse;
		-webkit-box-pack: end;
		-ms-flex-pack: end;
		justify-content: flex-end;
	}
	.chat_message
	{
		transform: rotate(180deg);
	}
	.flex-container {}

	.chat-message {
		display: flex;
		flex-direction: row;
		align-items: center;
		margin-bottom:1rem!important;
		direction: rtl;
	}
	.chat-message.right
	{
		direction: ltr;
	}
	.chat-message .name
	{
		font-size: small!important;
	}
	.chat-message .date
	{
		font-size: smaller!important;
	}
	.avatar {
		height: 50px;
		width: 50px;
		border-radius: 100%;
		flex-grow: 0;
	}

	.message-body
	{
		background: var(--primary);
		color:var(--light);
		padding: 1rem;
		border-radius: 15px;
		width: fit-content;
	}
	.message {
		flex-grow: 1;
		flex-flow: row;
		margin-inline-start: 10px;
		max-width: 80%;
	}

	.message .part {
		flex-flow: column;
		overflow-wrap: anywhere;
	}
	.chat-room-header .userName{
		font-weight: 900;
		font-size: 1rem;
		padding: 0;
	}
	.chat-room-header .count{
		font-weight: 300;
		font-size: 0.8rem;
		padding: 0;
	}

</style>


<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<div id="<portlet:namespace />"></div>
		<aui:script require="<%= mainRequire %>">
			main.default('#<portlet:namespace />');
		</aui:script>
	</c:when>
	<c:otherwise>

	</c:otherwise>
</c:choose>