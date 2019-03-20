package cn.smartpolice.net;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyKeepAliveMessageFactory implements KeepAliveMessageFactory {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean isRequest(IoSession session, Object message) {
        return true;
    }

    @Override
    public boolean isResponse(IoSession session, Object message) {
        return false;
    }

    @Override
    public Object getRequest(IoSession session) {
        logger.debug(session.getRemoteAddress().toString());
        return null;
    }

    @Override
    public Object getResponse(IoSession session, Object request) {
        return null;
    }
}
