package com.tanim.newsapp.crypto

import android.util.Base64
import com.tanim.newsapp.data.Constant
import java.lang.Exception
import java.lang.StringBuilder
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Encrypt {
    private val ivspec: IvParameterSpec
    private val keyspec: SecretKeySpec
    private var cipher: Cipher? = null

    private val iv: String = Constant.IV_KEY
    private val secretKey: String = Constant.SECRET_KEY

    @Throws(Exception::class)
    fun encrypt(text: String?): ByteArray? {
        if (text == null || text.length == 0) throw Exception("Empty string")
        var encrypted: ByteArray? = null
        encrypted = try {
            cipher!!.doFinal(padString(text).toByteArray())
        } catch (e: Exception) {
            throw Exception("[encrypt] " + e.message)
        }
        return encrypted
    }

    companion object {
        private var enCrypt: Encrypt? = null
        @JvmStatic
        val instance: Encrypt?
            get() {
                if (enCrypt == null) {
                    enCrypt = Encrypt()
                }
                return enCrypt
            }
        var HEX_CHARS = charArrayOf(
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'a',
            'b',
            'c',
            'd',
            'e',
            'f'
        )

        @JvmStatic
        fun bytesToHex(bytes: ByteArray): String {
            val hexChars = CharArray(bytes.size * 2)
            for (j in bytes.indices) {
                val v = bytes[j].toInt() and 0xFF // Here is the conversion
                hexChars[j * 2] = Decrypt.HEX_CHARS[v.ushr(4)]
                hexChars[j * 2 + 1] = Decrypt.HEX_CHARS[v and 0x0F]
            }

            return String(hexChars)
        }

        fun hexToBytes(str: String?): ByteArray? {
            return if (str == null) {
                null
            } else if (str.length < 2) {
                null
            } else {
                val len = str.length / 2
                val buffer = ByteArray(len)
                for (i in 0 until len) {
                    buffer[i] = str.substring(i * 2, i * 2 + 2).toInt(16).toByte()
                }
                buffer
            }
        }

        private fun padString(source: String): String {
            val paddingChar = 0.toChar()
            val size = 16
            val x = source.length % size
            val padLength = size - x
            val sourceBuilder = StringBuilder(source)
            for (i in 0 until padLength) {
                sourceBuilder.append(paddingChar)
            }
            return sourceBuilder.toString()
        }
    }

    init {
        ivspec = IvParameterSpec(Base64.decode(iv, 0))
        keyspec = SecretKeySpec(Base64.decode(secretKey, 0), "AES")
        try {
            //cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher = Cipher.getInstance("AES/CBC/NoPadding")
            cipher?.init(Cipher.ENCRYPT_MODE, keyspec, ivspec)
        } catch (e: NoSuchAlgorithmException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: NoSuchPaddingException) {
            e.printStackTrace()
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        } catch (e: InvalidKeyException) {
            e.printStackTrace()
        }
    }
}