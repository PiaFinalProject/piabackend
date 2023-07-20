package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.request.CartRequest;
import com.teknokafalar.piabackend.dto.response.CartResponse;
import com.teknokafalar.piabackend.entities.Book;
import com.teknokafalar.piabackend.entities.Cart;
import com.teknokafalar.piabackend.entities.CartItem;
import com.teknokafalar.piabackend.entities.User;
import com.teknokafalar.piabackend.repository.BookRepository;
import com.teknokafalar.piabackend.repository.CartItemRepository;
import com.teknokafalar.piabackend.repository.CartRepository;
import com.teknokafalar.piabackend.repository.UserRepository;
import com.teknokafalar.piabackend.service.abstracts.CartItemService;
import com.teknokafalar.piabackend.service.abstracts.CartService;
import com.teknokafalar.piabackend.util.CartMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final CartMapperUtil mapperUtil;
    private final CartItemService cartItemService;

    @Override
    public List<CartResponse> getCart() {
        return CartMapperUtil.cartResponseList(this.cartRepository.findAll());

    }

    @Override
    public Result postCart(CartRequest request, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Kullanıcı bulunamadı."));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new IllegalArgumentException("Kitap bulunamadı."));

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

        double quantity = request.getQuantity();
        if (quantity <= 0) {
            throw new IllegalArgumentException("Ürün adedi değiştirilmeli.");
        }

        if (book.getStock() >= quantity) {
            CartItem cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setQuantity(quantity);
            cartItem.setTotalPrice(quantity * book.getPrice());
            cartItem.setCart(cart);
            cart.getCartItems().add(cartItem);
            cart.setTotalPrice(cart.getTotalPrice() + cartItem.getTotalPrice());
            cartRepository.save(cart);
            //cartItemRepository.saveAndFlush(cartItem);


        } else {
            return new ErrorDataResult<>("Yetersiz stok miktarı.");
        }

        return new SuccessDataResult<>("Başarıyla kaydedildi.");
    }

    @Override
    public CartResponse updateCart(CartRequest request, Long cartId) {
//        Optional<Cart> cartDb = this.cartRepository.findById(cartId);
//        Optional<CartItem> cartItemDb = this.cartItemRepository.findById(request.getCartItemId());
//        Optional<User> userDb = this.userRepository.findById(request.getUserId());
//
//        Cart  cart = null;
//        if (cartDb.isPresent()){
//            //cart.setTotalPrice(request.getTotalPrice());
//            if (cartItemDb.isPresent()){
//                CartItem cartItem = cartItemDb.get();
//                //cart.setCartItem(cartItem);
//            }
//            if (userDb.isPresent()){
//                User user = userDb.get();
//                cart.setUser(user);
//            }
//
//        }
//        Cart updateCartItem = cartRepository.save(cart);
        return null;
    }

    @Override
    public CartResponse deleteCart(Long cartId) {
        Optional<Cart> cartDb = this.cartRepository.findById(cartId);
        Cart cart = cartDb.get();
        this.cartRepository.deleteById(cartId);
        return null;
    }
}
