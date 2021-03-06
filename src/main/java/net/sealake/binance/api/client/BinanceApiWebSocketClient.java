package net.sealake.binance.api.client;

import net.sealake.binance.api.client.domain.event.AggTradeEvent;
import net.sealake.binance.api.client.domain.event.AllMarketTickersEvent;
import net.sealake.binance.api.client.domain.event.CandlestickEvent;
import net.sealake.binance.api.client.domain.event.DepthEvent;
import net.sealake.binance.api.client.domain.event.UserDataUpdateEvent;
import net.sealake.binance.api.client.domain.market.CandlestickInterval;

import java.io.Closeable;
import java.util.List;

/**
 * Binance API data streaming façade, supporting streaming of events through web sockets.
 */
public interface BinanceApiWebSocketClient extends Closeable {

    /**
     * Open a new web socket to receive {@link DepthEvent depthEvents} on a callback.
     *
     * @param symbol   the market symbol to subscribe to
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onDepthEvent(String symbol, BinanceApiCallback<DepthEvent> callback);

    /**
     * Open a new web socket to receive {@link CandlestickEvent candlestickEvents} on a callback.
     *
     * @param symbol   the market symbol to subscribe to
     * @param interval the interval of the candles tick events required
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onCandlestickEvent(String symbol, CandlestickInterval interval, BinanceApiCallback<CandlestickEvent> callback);

    /**
     * Open a new web socket to receive {@link AggTradeEvent aggTradeEvents} on a callback.
     *
     * @param symbol   the market symbol to subscribe to
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onAggTradeEvent(String symbol, BinanceApiCallback<AggTradeEvent> callback);

    /**
     * Open a new web socket to receive {@link UserDataUpdateEvent userDataUpdateEvents} on a callback.
     *
     * @param listenKey the listen key to subscribe to.
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback);

    /**
     * Open a new web socket to receive {@link AllMarketTickersEvent allMarketTickersEvents} on a callback.
     *
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onAllMarketTickersEvent(BinanceApiCallback<List<AllMarketTickersEvent>> callback);

    void close();
}
