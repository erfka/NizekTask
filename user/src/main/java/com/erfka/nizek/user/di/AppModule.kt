package com.erfka.nizek.user.di

import android.app.Application
import androidx.room.Room
import com.erfka.nizek.user.data.local.database.UserDatabase
import com.erfka.nizek.user.data.mapper.UserMapper
import com.erfka.nizek.user.data.repository.UserRepositoryImpl
import com.erfka.nizek.user.domain.repository.UserRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao, UserMapper())
    }


}